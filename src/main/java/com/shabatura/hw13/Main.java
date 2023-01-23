package com.shabatura.hw13;

import java.util.Arrays;

public class Main {
    static void bubbleSort(int[] array) {
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }
        }
    }

        public static int binarySearch(int[] array, int key) {
        int index = Integer.MAX_VALUE;
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (array[mid] < key) {
                low = mid + 1;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else if (array[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {9, 2, 5, 6, 1, 10, 8};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch(array, 5));
    }
}
