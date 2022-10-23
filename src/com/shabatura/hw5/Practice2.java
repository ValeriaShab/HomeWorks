package com.shabatura.hw5;

import java.util.Arrays;
import java.util.Random;

public class Practice2 {
    public static void main(String[] args) {
        double[] costs = new double[12];
        fillRandomArray(costs);
        System.out.println(Arrays.toString(costs));
        System.out.printf("Sum = %.2f %n", costOfAllProductsOverThousand(costs));
    }

    private static void fillRandomArray(double[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble() * 2000;
        }
    }

    public static double costOfAllProductsOverThousand(double[] costs) {
        double sum = 0;
        for (double cost : costs) {
            if (cost >= 1000) {
                sum += cost;
            }
        }
        return sum;
    }
}
