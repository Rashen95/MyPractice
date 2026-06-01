package ru.privalov.recursion;

public class EightQueens {

    private static int count = 0;

    public static void main(String[] args) {
        int tableSize = 8;
        int[][] table = new int[tableSize][tableSize];
        putQueen(table, 0);
    }

    public static void putQueen(int[][] array, int j) {
        if (j == array.length) {
            printMassive(array);
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (isSafe(array, i, j)) {
                array[i][j] = 1;
                putQueen(array, j + 1);
                array[i][j] = 0;
            }
        }
    }

    public static boolean isSafe(int[][] array, int i, int j) {
        for (int currentJ = j - 1; currentJ >= 0; currentJ--) {
            if (array[i][currentJ] == 1) {
                return false;
            }
        }
        for (int currentI = i - 1, currentJ = j - 1; currentI >= 0 && currentJ >= 0; currentI--, currentJ--) {
            if (array[currentI][currentJ] == 1) {
                return false;
            }
        }
        for (int currentI = i + 1, currentJ = j - 1; currentI < array.length && currentJ >= 0; currentI++, currentJ--) {
            if (array[currentI][currentJ] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void printMassive(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
        System.out.println(++count + " вариант");
    }
}
