Selection Sort
def selection_sort(data):
    """Сортировка выбором — ищем минимальный элемент и ставим его в начало."""
    n = len(data)
    for i in range(n - 1):
        min_pos = i
        for j in range(i + 1, n):
            if data[j] < data[min_pos]:
                min_pos = j
        if min_pos != i:
            data[i], data[min_pos] = data[min_pos], data[i]
    return data
🔹 Bubble Sort
def bubble_sort(data):
    """Пузырьковая сортировка — многократно обходим массив, меняя местами соседние элементы."""
    length = len(data)
    for i in range(length):
        swapped = False
        for j in range(0, length - i - 1):
            if data[j] > data[j + 1]:
                data[j], data[j + 1] = data[j + 1], data[j]
                swapped = True
        if not swapped:
            break
    return data
🔹 Insertion Sort
def insertion_sort(data):
    """Сортировка вставками — каждый элемент вставляется в нужное место в отсортированной части."""
    for i in range(1, len(data)):
        current = data[i]
        j = i - 1
        while j >= 0 and data[j] > current:
            data[j + 1] = data[j]
            j -= 1
        data[j + 1] = current
    return data
🔹 Merge Sort
def merge_sort(data):
    """Сортировка слиянием — делим массив пополам и сливаем отсортированные части."""
    if len(data) <= 1:
        return data

    middle = len(data) // 2
    left = merge_sort(data[:middle])
    right = merge_sort(data[middle:])
    return merge(left, right)

def merge(a, b):
    """Слияние двух отсортированных списков."""
    result = []
    i = j = 0
    while i < len(a) and j < len(b):
        if a[i] <= b[j]:
            result.append(a[i])
            i += 1
        else:
            result.append(b[j])
            j += 1
    result.extend(a[i:])
    result.extend(b[j:])
    return result
🔹 Shell Sort
def shell_sort(data):
    """Сортировка Шелла — выполняем сортировку вставками с уменьшающимся шагом."""
    n = len(data)
    gap = n // 2
    while gap > 0:
        for i in range(gap, n):
            temp = data[i]
            j = i
            while j >= gap and data[j - gap] > temp:
                data[j] = data[j - gap]
                j -= gap
            data[j] = temp
        gap //= 2
    return data
🔹 Quick Sort
def quick_sort(data):
    """Быстрая сортировка — разделяем элементы относительно опорного."""
    if len(data) < 2:
        return data

    pivot = data[len(data) // 2]
    less = [x for x in data if x < pivot]
    equal = [x for x in data if x == pivot]
    greater = [x for x in data if x > pivot]

    return quick_sort(less) + equal + quick_sort(greater)
🔹 Heap Sort
def heap_sort(data):
    """Пирамидальная сортировка — строим кучу и извлекаем максимумы."""
    n = len(data)

    for i in range(n // 2 - 1, -1, -1):
        _heapify(data, n, i)

    for end in range(n - 1, 0, -1):
        data[0], data[end] = data[end], data[0]
        _heapify(data, end, 0)

    return data

def _heapify(arr, size, root):
    largest = root
    left = 2 * root + 1
    right = 2 * root + 2

    if left < size and arr[left] > arr[largest]:
        largest = left
    if right < size and arr[right] > arr[largest]:
        largest = right

    if largest != root:
        arr[root], arr[largest] = arr[largest], arr[root]
        _heapify(arr, size, largest)
🔹 Linear Search
def linear_search(data, key):
    """Последовательный поиск — проверяем элементы один за другим."""
    for i, value in enumerate(data):
        if value == key:
            return i
    return -1
🔹 Binary Search
def binary_search(data, key):
    """Бинарный поиск — делим область поиска пополам."""
    left, right = 0, len(data) - 1
    while left <= right:
        mid = (left + right) // 2
        if data[mid] == key:
            return mid
        elif data[mid] < key:
            left = mid + 1
        else:
            right = mid - 1
    return -1
🔹 Interpolation Search
def interpolation_search(data, key):
    """Интерполяционный поиск — улучшенный бинарный, позиция вычисляется по формуле."""
    low, high = 0, len(data) - 1

    while low <= high and key >= data[low] and key <= data[high]:
        if data[low] == data[high]:
            return low if data[low] == key else -1

        pos = low + ((key - data[low]) * (high - low)) // (data[high] - data[low])

        if data[pos] == key:
            return pos
        elif data[pos] < key:
            low = pos + 1
        else:
            high = pos - 1
    return -1
🔹 Fibonacci Search
def fibonacci_search(data, key):
    """Поиск Фибоначчи — делит массив по числам Фибоначчи."""
    n = len(data)
    fib2, fib1 = 0, 1
    fib = fib1 + fib2

    while fib < n:
        fib2, fib1 = fib1, fib
        fib = fib1 + fib2

    offset = -1

    while fib > 1:
        i = min(offset + fib2, n - 1)
        if data[i] < key:
            fib, fib1, fib2 = fib1, fib2, fib - fib1
            offset = i
        elif data[i] > key:
            fib, fib1, fib2 = fib2, fib1 - fib2, fib - fib1
        else:
            return i

    if fib1 == 1 and offset + 1 < n and data[offset + 1] == key:
        return offset + 1
    return -1
