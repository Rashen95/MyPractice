package ru.privalov.recursion;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ImprovedEightQueens {
    private static final int tableSize = 16;
    private static final AtomicLong count = new AtomicLong(0);
    private static final ExecutorService executorService = Executors.newFixedThreadPool(tableSize);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start in: " + LocalTime.now());

        boolean[] rows = new boolean[tableSize];
        boolean[] diag1 = new boolean[tableSize * 2 - 1];
        boolean[] diag2 = new boolean[tableSize * 2 - 1];

        putQueen(0, rows, diag1, diag2);

        executorService.shutdown();

        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);

        System.out.println("End in: " + LocalTime.now());
        System.out.printf("Количество вариантов расстановки %s ферзей на доске %s*%s: %s\n", tableSize, tableSize, tableSize, count);
    }

    public static void putQueen(int j, boolean[] rows, boolean[] diag1, boolean[] diag2) {
        if (j == tableSize) {
            count.addAndGet(1);
            return;
        }

        for (int i = 0; i < tableSize; i++) {
            int d1 = i + j;
            int d2 = i - j + tableSize - 1;

            if (!rows[i] && !diag1[d1] && !diag2[d2]) {
                rows[i] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                if (j == 0) {
                    boolean[] rowsCopy = Arrays.copyOf(rows, rows.length);
                    boolean[] diag1Copy = Arrays.copyOf(diag1, diag1.length);
                    boolean[] diag2Copy = Arrays.copyOf(diag2, diag2.length);

                    executorService.execute(() -> putQueen(j + 1, rowsCopy, diag1Copy, diag2Copy));
                } else {
                    putQueen(j + 1, rows, diag1, diag2);
                }

                rows[i] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }
}
