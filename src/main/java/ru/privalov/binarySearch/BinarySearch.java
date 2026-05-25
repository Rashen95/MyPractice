package ru.privalov.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 8, 13, 16, 29, 33, 45, 76, 99};

        System.out.println(binarySearch(array, 33)); // 6
        System.out.println(binarySearch(array, 155)); // -1
    }

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
