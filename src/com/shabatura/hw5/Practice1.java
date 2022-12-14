package com.shabatura.hw5;

import java.util.Arrays;
import java.util.Random;

public class Practice1 {
    public static void main(String[] args) {
        int[] heightValues = new int[25];
        fillArray(heightValues);
        System.out.println(Arrays.toString(heightValues));
        System.out.println("Boys avg: " + getAvgBoyHeight(heightValues));
        System.out.println("Girls avg: " + getAvgGirlHeight(heightValues));
    }

    private static void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(200);
            if (random.nextBoolean()) {
                array[i] *= -1;
            }
        }
    }

    public static int getAvgBoyHeight(int[] heightValues) {
        return calcHeightSum(heightValues, true);
    }

    public static int getAvgGirlHeight(int[] heightValues) {
        return calcHeightSum(heightValues, false);
    }

    private static int calcHeightSum(int[] heightValues, boolean isBoy) {
        int sum = 0;
        int count = 0;
        for (int heightValue : heightValues) {
            if ((isBoy && heightValue < 0) || (!isBoy && heightValue > 0)) {
                count++;
                sum += heightValue;
            }
        }
        if (isBoy) {
            sum *= -1;
        }
        return count == 0 ? 0 : sum / count;
    }
}
