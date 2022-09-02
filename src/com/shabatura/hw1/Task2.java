package com.shabatura.hw1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String reverse = new StringBuffer(number).reverse().toString();
        System.out.println(reverse);
    }
}
