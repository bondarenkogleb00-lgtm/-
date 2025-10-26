public class SelectionSort {
 
   // Метод, реализующий сортировку выбором
   public static void selectionSort(int[] array) {
       int n = array.length; // Получаем длину массива
       
       for (int i = 0; i < n - 1; i++) { // Проходим по массиву слева направо
           int minIndex = i; // Предполагаем, что минимальный элемент находится на текущей позиции
           
           // Ищем минимальное значение справа от текущего индекса
           for (int j = i + 1; j < n; j++) {
               if (array[j] < array[minIndex]) { // Если нашли меньший элемент
                   minIndex = j; // Запоминаем индекс нового минимума
               }
           }
           
           // Меняем местами найденный минимум с элементом на текущей позиции
           swap(array, i, minIndex);
       }
   }
   
   // Вспомогательная функция для обмена двух элементов в массиве
   private static void swap(int[] arr, int index1, int index2) {
       int temp = arr[index1];     // Сохраняем первый элемент временно
       arr[index1] = arr[index2];   // Присваиваем первому элементу второй
       arr[index2] = temp;         // Второй элемент становится первым
   }
   
   // Основная точка входа программы
   public static void main(String[] args) {
       int[] exampleArray = {64, 25, 12, 22, 11}; // Пример массива
       
       System.out.println("Исходный массив:");
       printArray(exampleArray); // Печать исходного массива
       
       selectionSort(exampleArray); // Сортируем массив методом выбора
       
       System.out.println("\nОтсортированный массив:");
       printArray(exampleArray); // Печать отсортированного массива
   }
   
   // Функция для печати содержимого массива
   private static void printArray(int[] arr) {
       for (int value : arr) {
           System.out.print(value + " ");
       }
       System.out.println();
   }
}
public class BubbleSort {
 
   // Реализация метода пузырьковой сортировки
   public static void bubbleSort(int[] array) {
       int n = array.length; // Длина массива
       
       // Цикл по всей длине массива
       for (int i = 0; i < n - 1; i++) {
           boolean swapped = false; // Флаг, сигнализирующий, были ли изменения
           
           // Внутренний цикл идет до последнего неотсортированного элемента
           for (int j = 0; j < n - i - 1; j++) {
               // Проверяем, больше ли текущий элемент следующего
               if (array[j] > array[j + 1]) {
                   // Меняем элементы местами
                   int temp = array[j];
                   array[j] = array[j + 1];
                   array[j + 1] = temp;
                   
                   swapped = true; // Изменили порядок, значит была замена
               }
           }
           
           // Если ни одной замены не произошло, массив уже отсортирован
           if (!swapped) break;
       }
   }
   
   // Основной метод для запуска примера
   public static void main(String[] args) {
       int[] exampleArray = {64, 34, 25, 12, 22, 11};
       
       System.out.println("Исходный массив:");
       printArray(exampleArray); // выводим начальное состояние массива
       
       bubbleSort(exampleArray); // запускаем сортировку
       
       System.out.println("\nОтсортированный массив:");
       printArray(exampleArray); // выводим конечное состояние массива
   }
   
   // Простая вспомогательная функция для вывода массива
   private static void printArray(int[] arr) {
       for (int value : arr) {
           System.out.print(value + " ");
       }
       System.out.println(); // Перевод строки
   }
}
public class InsertionSort {
 
   // Реализуем метод сортировки вставками
   public static void insertionSort(int[] array) {
       int n = array.length; // Определяем размер массива
       
       // Начинаем с второго элемента (i=1), считая первый элемент уже отсортированным
       for (int i = 1; i < n; ++i) {
           int key = array[i]; // Берём текущий элемент
           int j = i - 1; // Переменная для движения назад по отсортированной части
           
           /* Двигаемся назад по отсортированной части,
              пока ключ меньше предыдущего элемента */
           while (j >= 0 && array[j] > key) {
               array[j + 1] = array[j]; // Смещаем больший элемент вправо
               j--;                     // Переходим к предыдущему элементу
           }
           
           // Вставляем ключ на его правильную позицию
           array[j + 1] = key;
       }
   }
   
   // Главный метод для демонстрации работы
   public static void main(String[] args) {
       int[] exampleArray = {12, 11, 13, 5, 6};
       
       System.out.println("Исходный массив:");
       printArray(exampleArray); // Показываем первоначальный массив
       
       insertionSort(exampleArray); // Применяем сортировку вставками
       
       System.out.println("\nОтсортированный массив:");
       printArray(exampleArray); // Отображаем отсортированный массив
   }
   
   // Вспомогательная функция для отображения массива
   private static void printArray(int[] arr) {
       for (int value : arr) {
           System.out.print(value + " ");
       }
       System.out.println(); // Перенос строки
   }
}
import java.util.Arrays;
 
public class MergeSort {
 
   // Реализуем основную процедуру сортировки слиянием
   public static void mergeSort(int[] array) {
       if (array.length <= 1) return; // Базовый случай рекурсии
       
       // Разделяем массив пополам
       int mid = array.length / 2;
       int[] leftHalf = Arrays.copyOfRange(array, 0, mid); // Левая половина
       int[] rightHalf = Arrays.copyOfRange(array, mid, array.length); // Правая половина
       
       // Рекурсивно сортируем левую и правую половину
       mergeSort(leftHalf);
       mergeSort(rightHalf);
       
       // Объединяем отсортированные половины
       merge(array, leftHalf, rightHalf);
   }
   
   // Процедура объединения двух отсортированных частей в единый массив
   private static void merge(int[] result, int[] left, int[] right) {
       int i = 0, j = 0, k = 0; // Индексы для левого, правого и результирующего массивов
       
       // Пока оба массива содержат элементы
       while (i < left.length && j < right.length) {
           if (left[i] <= right[j]) { // Выбираем меньший элемент
               result[k++] = left[i++]; // Добавляем элемент из левой части
           } else {
               result[k++] = right[j++]; // Добавляем элемент из правой части
           }
       }
       
       // Копируем оставшиеся элементы из левой части, если они остались
       while (i < left.length) {
           result[k++] = left[i++];
       }
       
       // Копируем оставшиеся элементы из правой части, если они остались
       while (j < right.length) {
           result[k++] = right[j++];
       }
   }
   
   // Точка входа программы
   public static void main(String[] args) {
       int[] exampleArray = {38, 27, 43, 3, 9, 82, 10};
       
       System.out.println("Исходный массив:");
       printArray(exampleArray); // Выводим исходный массив
       
       mergeSort(exampleArray); // Выполняем сортировку слиянием
       
       System.out.println("\nОтсортированный массив:");
       printArray(exampleArray); // Выводим отсортированный массив
   }
   
   // Вспомогательная функция для вывода массива
   private static void printArray(int[] arr) {
       for (int value : arr) {
           System.out.print(value + " ");
       }
       System.out.println(); // Перенос строки
   }
}
public class ShellSort {
 
   // Реализация процедуры сортировки Шелла
   public static void shellSort(int[] array) {
       int n = array.length; // длина массива
       
       // Используем классический интервал Хиббарда: h(i) = 2^i - 1
       for (int gap = n / 2; gap > 0; gap /= 2) { // Уменьшаем расстояние между элементами
           // Производим частичную сортировку для заданного расстояния
           for (int i = gap; i < n; i += 1) {
               int temp = array[i]; // сохраняем текущий элемент
               
               // Сдвигаем предыдущие элементы, если они больше текущего
               int j;
               for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                   array[j] = array[j - gap]; // сдвигаем элемент дальше
               }
               
               // Вставляем текущий элемент на освободившееся место
               array[j] = temp;
           }
       }
   }
   
   // Демонстрационный метод для тестирования
   public static void main(String[] args) {
       int[] exampleArray = {23, 12, 1, 8, 34, 56, 7};
       
       System.out.println("Исходный массив:");
       printArray(exampleArray); // выводим исходный массив
       
       shellSort(exampleArray); // применяем сортировку Шелла
       
       System.out.println("\nОтсортированный массив:");
       printArray(exampleArray); // выводим отсортированный массив
   }
   
   // Вспомогательная функция для вывода массива
   private static void printArray(int[] arr) {
       for (int value : arr) {
           System.out.print(value + " ");
       }
       System.out.println(); // перенос строки
   }
}
public class QuickSort {
 
   // Главная процедура быстрой сортировки
   public static void quickSort(int[] array, int low, int high) {
       if (low < high) {                      // Условие выхода из рекурсии
           int pi = partition(array, low, high); // Находим точку разделения
           
           // Рекурсивно сортируем левую и правую части
           quickSort(array, low, pi - 1);    // Сортируем левую сторону
           quickSort(array, pi + 1, high);   // Сортируем правую сторону
       }
   }
   
   // Метод для разделения массива вокруг опорного элемента
   private static int partition(int[] array, int low, int high) {
       int pivot = array[high];             // Опорный элемент (обычно последний элемент)
       int i = low - 1;                     // Индекс меньшей секции
       
       // Пересматриваем массив от низкого до высокого индексов
       for (int j = low; j < high; j++) {
           if (array[j] <= pivot) {           // Если текущий элемент меньше или равен опоре
               i++;                           // Увеличим индекс меньших элементов
               swap(array, i, j);            // Поменяем местами
           }
       }
       
       // Поместим опорный элемент на своё место
       swap(array, i + 1, high);
       return i + 1;                         // Возвращаем индекс опорного элемента
   }
   
   // Вспомогательная функция для обмена местоположением элементов
   private static void swap(int[] arr, int a, int b) {
       int temp = arr[a];
       arr[a] = arr[b];
       arr[b] = temp;
   }
   
   // Тестирование алгоритма
   public static void main(String[] args) {
       int[] exampleArray = {10, 7, 8, 9, 1, 5};
       
       System.out.println("Исходный массив:");
       printArray(exampleArray); // Выводим исходный массив
       
       quickSort(exampleArray, 0, exampleArray.length - 1); // Применяем быструю сортировку
       
       System.out.println("\nОтсортированный массив:");
       printArray(exampleArray); // Выводим отсортированный массив
   }
   
   // Вспомогательная функция для вывода массива
   private static void printArray(int[] arr) {
       for (int value : arr) {
           System.out.print(value + " ");
       }
       System.out.println(); // Перенос строки
   }
}
public class HeapSort {
   
   // Основная функция для сортировки массива методом heap sort
   public static void heapSort(int[] arr) {
       int n = arr.length;
       
       // Шаг 1: строим max-кучу (перестановка элементов)
       for (int i = n / 2 - 1; i >= 0; i--) { // начинаем с середины и идём назад
           heapify(arr, n, i);              // превращаем дерево в кучу снизу-вверх
       }
       
       // Шаг 2: извлекаем элементы из кучи последовательно и сортируем
       for (int i = n - 1; i > 0; i--) {
           swap(arr, 0, i);                // меняем корень (max-элемент) с последним элементом
           heapify(arr, i, 0);             // восстанавливаем свойства кучи уменьшенной длины
       }
   }
   
   // Вспомогательная функция для перестройки дерева в max-кучу
   private static void heapify(int[] arr, int size, int rootIndex) {
       int largest = rootIndex;    // индекс наибольшего элемента
       int leftChild = 2 * rootIndex + 1;   // левый потомок
       int rightChild = 2 * rootIndex + 2; // правый потомок
       
       if (leftChild < size && arr[leftChild] > arr[largest]) {
           largest = leftChild;      // проверяем левого ребёнка
       }
       
       if (rightChild < size && arr[rightChild] > arr[largest]) {
           largest = rightChild;     // проверяем правого ребёнка
       }
       
       if (largest != rootIndex) {    // если произошло изменение максимума
           swap(arr, rootIndex, largest); // меняем местами элементы
           heapify(arr, size, largest);   // рекурсивно восстанавливаем кучу ниже
       }
   }
   
   // Простая вспомогательная функция для обмена двух элементов массива
   private static void swap(int[] arr, int i, int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
   }
}
public class LinearSearch {
 
   // Метод для реализации последовательного поиска
   public static int linearSearch(int[] array, int target) {
       // Проходим по каждому элементу массива
       for (int i = 0; i < array.length; i++) {
           // Если текущий элемент равен целевому числу
           if (array[i] == target) {
               return i; // Возвращаем индекс найденного элемента
           }
       }
       return -1; // Если элемент не найден, возвращаем -1
   }
 
   // Тестовая функция для демонстрации работы метода
   public static void main(String[] args) {
       int[] data = {3, 8, 1, 10, 5};
       int key = 10;
       int result = linearSearch(data, key);
       
       if (result != -1) {
           System.out.println("Элемент " + key + " найден на индексе " + result);
       } else {
           System.out.println("Элемент " + key + " не найден");
       }
   }
}
public class BinarySearch {
 
   // Основной метод бинарного поиска
   public static int binarySearch(int[] array, int target) {
       int low = 0;         // Левая граница области поиска
       int high = array.length - 1; // Правая граница области поиска
       
       while (low <= high) {           // Пока левая граница меньше или равна правой
           int mid = low + (high - low) / 2; // Вычисляем середину
           
           if (array[mid] == target) {   // Если средний элемент равен цели
               return mid;              // Возврат индекса
           } else if (array[mid] < target) { // Если цель больше среднего элемента
               low = mid + 1;            // Уменьшаем левую границу
           } else {                       // Иначе цель меньше среднего элемента
               high = mid - 1;           // Уменьшаем правую границу
           }
       }
       return -1;                        // Цель не найдена
   }
 
   // Тестовая функция для демонстрации работы
   public static void main(String[] args) {
       int[] sortedArray = {1, 3, 5, 7, 9, 11}; // Отсортированный массив
       int searchKey = 7;                       // Искомое значение
       int index = binarySearch(sortedArray, searchKey);
       
       if (index != -1) {
           System.out.println("Значение " + searchKey + " найдено на индексе " + index);
       } else {
           System.out.println("Значение " + searchKey + " не найдено в массиве.");
       }
   }
}
public class InterpolationSearch {
 
   // Основной метод интерполирующего поиска
   public static int interpolationSearch(int[] array, int target) {
       int low = 0;                    // Нижняя граница области поиска
       int high = array.length - 1;    // Верхняя граница области поиска
       
       while ((low <= high) && (target >= array[low]) && (target <= array[high])) {
           // Формула для оценки положения целевого элемента
           int pos = low + (((double)(high - low) / (array[high] - array[low]))
                            * (target - array[low]));
           
           // Если найден точный элемент
           if (array[pos] == target) {
               return pos;             // Вернуть индекс
           }
           
           // Если цель находится левее предполагаемого места
           if (array[pos] < target) {
               low = pos + 1;          // Переносим нижнюю границу вправо
           } else {
               high = pos - 1;         // Переносим верхнюю границу влево
           }
       }
       return -1;                      // Целевой элемент не найден
   }
 
   // Тестовая функция для демонстрации работы
   public static void main(String[] args) {
       int[] sortedArray = {10, 15, 20, 25, 30, 35, 40, 45, 50}; // Большой равномерно распределённый массив
       int searchKey = 35;                                         // Искомое значение
       int index = interpolationSearch(sortedArray, searchKey);
       
       if (index != -1) {
           System.out.println("Значение " + searchKey + " найдено на индексе " + index);
       } else {
           System.out.println("Значение " + searchKey + " не найдено в массиве.");
       }
   }
}
import java.util.Arrays;
 
public class FibonacciSearch {
 
   // Функция поиска элемента с использованием последовательности Фибоначчи
   public static int fibonacciSearch(int[] array, int x) {
       int m = findMinFibonacciNumberGreaterOrEqualTo(array.length); // находим минимальное число Фибоначчи >= длине массива
       int offset = -1;                                              // смещение начала поиска
       int f1 = 0;                                                   // предыдущее число Фибоначчи
       int f2 = 1;                                                   // текущее число Фибоначчи
       int nextF = m;                                                // следующее число Фибоначчи
       
       // Передвижение окна поиска
       while (nextF > 1) {
           int i = Math.min(offset + f1, array.length - 1);          // рассчитываем новую позицию
           
           // Если элемент больше искомого, двигаем окно вправо
           if (array[i] < x) {
               nextF = f2;
               f2 = f1;
               f1 = nextF - f2;
               offset = i;
           }
           // Если элемент меньше искомого, двигаем окно влево
           else if (array[i] > x) {
               nextF = f1;
               f2 -= f1;
               f1 = nextF - f2;
           }
           // Если нашли элемент, возвращаем его индекс
           else {
               return i;
           }
       }
       
       // Последний проход по оставшимся двум элементам
       if (f2 == 1 && array[offset + 1] == x) {
           return offset + 1;
       }
       
       return -1;                                                    // элемент не найден
   }
 
   // Нахождение минимального числа Фибоначчи, большего или равного заданному числу
   private static int findMinFibonacciNumberGreaterOrEqualTo(int length) {
       int f1 = 0;
       int f2 = 1;
       int nextF = f1 + f2;
       
       while (nextF < length) {
           f1 = f2;
           f2 = nextF;
           nextF = f1 + f2;
       }
       
       return nextF;
   }
 
   // Тестовая функция для демонстрации работы
   public static void main(String[] args) {
       int[] sortedArray = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
       int x = 85;
       int result = fibonacciSearch(sortedArray, x);
       
       if(result != -1){
           System.out.println("Элемент " + x + " найден на индексе " + result);
       }else{
           System.out.println("Элемент " + x + " не найден в массиве.");
       }
   }
}
