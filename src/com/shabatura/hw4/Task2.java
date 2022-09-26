package com.shabatura.hw4;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = new int[1000];
        fillRandomArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(findPrimeNumbers(numbers));
        System.out.println(findCompositeNumbers(numbers));
    }

    private static void fillRandomArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private static int findPrimeNumbers(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isPrime = true;
            if (array[i] == 1)
                isPrime = false;
            else {
                for (int j = 2; j <= array[i] / 2; j++) {
                    if (array[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                count++;
            }

        }
        return count;
    }

    private static int findCompositeNumbers(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isPrime = false;
            if (array[i] == 1)
                isPrime = false;
            else {
                for (int j = 2; j <= array[i] / 2; j++) {
                    if (array[i] % j == 0) {
                        isPrime = true;
                        break;
                    }
                }
            }
            if (isPrime) {
                count++;
            }

        }
        return count;
    }
}
