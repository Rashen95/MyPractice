package ru.privalov.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 15, 1, 71, 6, 1589, 799, 88, -54, 0};

        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int buffer = array[i];
                array[i] = array[minIndex];
                array[minIndex] = buffer;
            }
        }

        return array;
    }
}
