package ru.privalov.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 15, 1, 71, 6, 1589, 799, 88, -54, 0};

        sort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int indexFirstElement, int indexSecondElement) {
        int buffer = array[indexFirstElement];
        array[indexFirstElement] = array[indexSecondElement];
        array[indexSecondElement] = buffer;
    }
}
