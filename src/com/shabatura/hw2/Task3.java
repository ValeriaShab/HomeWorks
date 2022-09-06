package com.shabatura.hw2;

public class Task3 {
    public static void main(String[] args) {
        calcLeast(3, 4, -5);
    }

    private static void calcLeast(int num1, int num2, int num3) {
        if ((Math.abs(num1)) < (Math.abs(num2)) && (Math.abs(num1)) < (Math.abs(num3))) {
            System.out.println("Наименшее значение: " + num1);
        } else if ((Math.abs(num2)) < (Math.abs(num1)) && (Math.abs(num2)) < (Math.abs(num3))) {
            System.out.println("Наименшее значение: " + num2);
        } else {
            System.out.println("Наименшее значение: " + num3);
        }
    }
}
