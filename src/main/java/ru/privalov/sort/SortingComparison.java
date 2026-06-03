package ru.privalov.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class SortingComparison {

    public static void main(String[] args) {
        int amountElements = 100_000;

        int[] array1 = IntStream
                .generate(() -> ThreadLocalRandom.current().nextInt(-100, 101))
                .limit(amountElements)
                .toArray();
        int[] array2 = Arrays.copyOf(array1, array1.length);

        long start;
        long end;

        start = System.nanoTime();
        QuickSort.quickSort(array1);
        end = System.nanoTime();
        System.out.printf(
                "Быстрая сортировка справилась c сортировкой массива из %s элементов за %sмс\n",
                amountElements, (end - start) / 1_000_000
        );

        start = System.nanoTime();
        SelectionSort.sort(array2);
        end = System.nanoTime();
        System.out.printf(
                "Сортировка выбором справилась c сортировкой массива из %s элементов за %sмс\n",
                amountElements, (end - start) / 1_000_000
        );
    }
}
