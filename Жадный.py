задание номер 7

def read_intervals():
    """
    Функция для чтения интервалов от пользователя.
    Можно вводить интервалы построчно в формате:
    1 3
    2 5
    7 10
    Пустая строка — завершение ввода.
    """
    print("Введите интервалы в формате <start end>. Пустая строка — конец.")

    intervals = []
    while True:
        line = input("Интервал: ").strip()
        if line == "":
            break
        parts = line.split()

        # проверка корректности ввода
        if len(parts) != 2:
            print("Ошибка: нужно вводить ровно два числа.")
            continue

        try:
            start = int(parts[0])
            end = int(parts[1])
        except ValueError:
            print("Ошибка: оба значения должны быть числами.")
            continue

        if end < start:
            print("Ошибка: конец интервала не может быть меньше начала.")
            continue

        intervals.append((start, end))

    return intervals


def print_intervals(title, intervals):
    """
    Красивый вывод интервалов с поясняющим заголовком.
    """
    print("\n" + title)
    print("-" * len(title))
    for i, (s, e) in enumerate(intervals, 1):
        print(f"{i:2d}) [{s}, {e}]")
    print()


def interval_scheduling(intervals):
    """
    Жадный алгоритм выбора максимального числа непересекающихся интервалов.
    Алгоритм:
    1) сортируем по возрастанию времени окончания
    2) последовательно пытаемся добавить интервал
    3) интервал добавляется, если он не пересекается с последним выбранным
    """

    # сортировка по времени окончания
    intervals.sort(key=lambda x: x[1])

    result = []          # список выбранных интервалов
    last_end = -10**18   # "минимально возможное" значение, чтобы первый интервал точно подошёл

    for start, end in intervals:
        # условие добавления интервала: он должен начинаться
        # НЕ РАНЬШЕ, чем заканчивается предыдущий выбранный
        if start >= last_end:
            result.append((start, end))
            last_end = end  # обновляем границу

    return result


def main():
    """
    Главная функция, объединяющая ввод, обработку и вывод результата.
    """
    # читаем интервалы
    intervals = read_intervals()

    # печатаем, что ввёл пользователь
    print_intervals("Вы ввели интервалы:", intervals)

    # выполняем жадный алгоритм
    selected = interval_scheduling(intervals)

    # вывод результата
    print_intervals("Выбранные (непересекающиеся) интервалы:", selected)
    print(f"Максимальное количество: {len(selected)}")


# Запуск программы
if __name__ == "__main__":
    main()
