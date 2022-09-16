package com.shabatura.hw5;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        fillRandomArray(array);
        for (int[] element : array) {
            System.out.println(Arrays.toString(element));
        }
        System.out.println();
        for (int[] element : moveColumnsAndLinesOfArray(array)) {
            System.out.println(Arrays.toString(element));
        }
        System.out.println();
        for (int[] element : array) {
            System.out.println(Arrays.toString(element));
        }
    }

    private static void fillRandomArray(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
    }

    private static int[][] moveColumnsAndLinesOfArray(int[][] array) {
        int[][] changedArray = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                changedArray[j][i] = array[i][j];
            }
        }
        return changedArray;
    }
}
