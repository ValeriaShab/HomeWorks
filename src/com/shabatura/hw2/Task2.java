package com.shabatura.hw2;

public class Task2 {
    public static void main(String[] args) {
        oddOrEven(7);
    }

    private static void oddOrEven(int number) {
        if (number % 2 == 0) {
            System.out.println("Четное");
        } else {
            System.out.println("Не четное");
        }
    }
}
