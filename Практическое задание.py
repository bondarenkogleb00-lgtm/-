вариант 7

import random
import math

# ---------------------- ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ ----------------------

def route_length(route, dist):
    """Вычисляет длину маршрута (с возвратом в стартовую точку)."""
    length = 0
    for i in range(len(route)):
        length += dist[route[i]][route[(i + 1) % len(route)]]
    return length


def two_opt(route):
    """Генерирует соседнее решение с помощью обмена 2-opt."""
    a = random.randint(0, len(route) - 1)
    b = random.randint(0, len(route) - 1)
    if a > b:
        a, b = b, a
    new_route = route[:a] + route[a:b+1][::-1] + route[b+1:]
    return new_route


def acceptance_probability(old_cost, new_cost, T):
    """Вероятность принятия худшего решения."""
    if new_cost < old_cost:
        return 1.0
    return math.exp(-(new_cost - old_cost) / T)


# ---------------------- ИМИТАЦИЯ ОТЖИГА ----------------------

def simulated_annealing(dist, T_start, alpha, iterations):
    n = len(dist)
    current = list(range(n))
    random.shuffle(current)

    best = current[:]
    best_cost = route_length(best, dist)
    current_cost = best_cost

    T = T_start
    improvements_by_temp = {}

    while T > 0.001:
        improvements = 0

        for _ in range(iterations):
            candidate = two_opt(current)
            candidate_cost = route_length(candidate, dist)

            if (candidate_cost < current_cost or
                random.random() < acceptance_probability(current_cost, candidate_cost, T)):
                current = candidate
                current_cost = candidate_cost

                if current_cost < best_cost:
                    best = current[:]
                    best_cost = current_cost
                    improvements += 1

        improvements_by_temp[T] = improvements
        T *= alpha  # охлаждение

    return best, best_cost, improvements_by_temp


# ---------------------- ВХОДНЫЕ ДАННЫЕ ----------------------

dist_matrix = [
    [0, 29, 20, 21, 16, 31, 100, 12],
    [29, 0, 15, 29, 28, 40, 72, 21],
    [20, 15, 0, 15, 14, 25, 81, 9],
    [21, 29, 15, 0, 4, 12, 92, 8],
    [16, 28, 14, 4, 0, 16, 94, 7],
    [31, 40, 25, 12, 16, 0, 95, 13],
    [100, 72, 81, 92, 94, 95, 0, 90],
    [12, 21, 9, 8, 7, 13, 90, 0]
]

T_start = 100
alpha = 0.95
iterations = 200


# ---------------------- ЗАПУСК ----------------------

best_route, best_cost, improvements = simulated_annealing(dist_matrix, T_start, alpha, iterations)

print("Лучший найденный маршрут:", best_route)
print("Его длина:", best_cost)

print("\nКоличество улучшений на разных температурах:")
for T, imp in improvements.items():
    print(f"T={T:.4f}  -> улучшений: {imp}")
