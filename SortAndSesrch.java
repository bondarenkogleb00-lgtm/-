SelectionSort (Сортировка выбором)
public class SelectionSort {
    public static void sort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }

            if (minPos != i) {
                int temp = array[i];
                array[i] = array[minPos];
                array[minPos] = temp;
            }
        }
    }
}
🔹 BubbleSort (Пузырьковая)
public class BubbleSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        boolean swapped;

        for (int i = 0; i < len - 1; i++) {
            swapped = false;

            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped) break; // Если обменов не было, массив уже отсортирован
        }
    }
}
🔹 InsertionSort (Вставками)
public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }
}
🔹 MergeSort (Слиянием)
public class MergeSort {
    public static void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        for (int i = 0; i < leftArr.length; i++) leftArr[i] = arr[left + i];
        for (int j = 0; j < rightArr.length; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }
}
🔹 ShellSort
public class ShellSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }
}
🔹 QuickSort (Быстрая)
public class QuickSort {
    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int pivotIndex = partition(arr, low, high);
        sort(arr, low, pivotIndex - 1);
        sort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int idx = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                idx++;
                int tmp = arr[idx];
                arr[idx] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[idx + 1];
        arr[idx + 1] = arr[high];
        arr[high] = tmp;

        return idx + 1;
    }
}
🔹 HeapSort (Пирамидальная)
public class HeapSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;

        if (largest != root) {
            int tmp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = tmp;

            heapify(arr, size, largest);
        }
    }
}
🔹 LinearSearch
public class LinearSearch {
    public static int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}
🔹 BinarySearch
public class BinarySearch {
    public static int find(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == value) return mid;
            if (arr[mid] < value) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
🔹 InterpolationSearch
public class InterpolationSearch {
    public static int find(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (arr[low] == arr[high]) {
                return arr[low] == key ? low : -1;
            }

            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == key) return pos;
            if (arr[pos] < key) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }
}
🔹 FibonacciSearch
public class FibonacciSearch {
    public static int find(int[] arr, int key) {
        int n = arr.length;
        int fib2 = 0, fib1 = 1, fib = fib1 + fib2;

        while (fib < n) {
            fib2 = fib1;
            fib1 = fib;
            fib = fib1 + fib2;
        }

        int offset = -1;

        while (fib > 1) {
            int i = Math.min(offset + fib2, n - 1);

            if (arr[i] < key) {
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            } else if (arr[i] > key) {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            } else {
                return i;
            }
        }

        if (fib1 == 1 && offset + 1 < n && arr[offset + 1] == key) return offset + 1;
        return -1;
    }
}
