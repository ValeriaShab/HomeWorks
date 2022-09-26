package com.shabatura.hw4;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[] numbers = new int[2000];
        fillRandomArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(changeToZero(numbers)));
        System.out.println(Arrays.toString(numbers));
    }

    private static void fillRandomArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
    }

    private static int[] changeToZero(int[] array) {
        int[] arrayClone= Arrays.copyOf(array,array.length);
        for (int i = 0; i < arrayClone.length; i++) {
            if (arrayClone[i] % 2 == 0) {
                arrayClone[i] = 0;
            }
        }
        return arrayClone;
    }
}
