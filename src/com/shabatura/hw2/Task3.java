package com.shabatura.hw2;

public class Task3 {
    public static void main(String[] args) {
        calcLeast(3, 4, -5);
    }

    private static void calcLeast(int num1, int num2, int num3) {
        int absNum1 = (num1 < 0) ? -num1 : num1;
        int absNum2 = (num2 < 0) ? -num2 : num2;
        int absNum3 = (num3 < 0) ? -num3 : num3;
        if (absNum1 < absNum2 && absNum1 < absNum3) {
            System.out.println("Наименшее значение: " + num1);
        } else if (absNum2 < absNum1 && absNum2 < absNum3) {
            System.out.println("Наименшее значение: " + num2);
        } else {
            System.out.println("Наименшее значение: " + num3);
        }
    }
}
