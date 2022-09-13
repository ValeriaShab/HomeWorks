package com.shabatura.hw4;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = new int[400];
        fillRandomArray(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("Arithmetic mean: " + findArithmeticMean(numbers));
        System.out.println("Geometric mean: " + findGeometricMean(numbers));
    }

    private static void fillRandomArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + random.nextInt(10);
        }
    }

    private static double findArithmeticMean(int[] array) {
        double arithAverage = 0;
        if (array.length > 0) {
            double sum = 0;
            for (int j : array) {
                sum += j;
            }
            arithAverage = sum / array.length;
        }
        return arithAverage;
    }

    private static double findGeometricMean(int[] array) {
        double sum = 1;
        for (int j : array) {
            sum *= j;
        }
        return Math.pow(sum, 1f / (float) array.length);
    }
}
