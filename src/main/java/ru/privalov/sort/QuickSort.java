package ru.privalov.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {9, 4, 7, 3, 1, 5, 8, 2, 6};

        quickSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int dividingIndex = getDivideIndex(array, pivot, left, right);

        quickSort(array, left, dividingIndex - 1);
        quickSort(array, dividingIndex, right);
    }

    private static int getDivideIndex(int[] array, int pivot, int left, int right) {
        while (left <= right) {
            // Ищем слева первый элемент, который не меньше pivot
            while (array[left] < pivot) {
                left++;
            }

            // Ищем справа первый элемент, который не больше pivot
            while (array[right] > pivot) {
                right--;
            }

            // Если элементы стоят не в своих частях, меняем их местами
            if (left <= right) {
                if (left < right) {
                    swap(array, left, right);
                }
                left++;
                right--;
            }
        }

        // Возвращаем индекс начала правой части: слева элементы <= pivot, справа элементы >= pivot
        return left;
    }

    private static void swap(int[] array, int indexFirstElement, int indexSecondElement) {
        int buffer = array[indexFirstElement];
        array[indexFirstElement] = array[indexSecondElement];
        array[indexSecondElement] = buffer;
    }
}
