package main.java.com.shabatura.hw9;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 8};
        System.out.println(Arrays.toString(array));
        System.out.println(checkArray(array));
    }

    public static boolean checkArray(int[] array) {
        int[] sorted = Arrays.copyOf(array, array.length);
        boolean changed;
        do {
            changed = false;
            for (int i = 1; i < sorted.length; i++) {
                if (sorted[i] > sorted[i - 1]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i - 1];
                    sorted[i - 1] = temp;

                    changed = true;
                }
            }
        } while (changed);

        boolean result = Arrays.equals(array, sorted);
        return result;
    }
}
