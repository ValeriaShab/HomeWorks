package com.shabatura.hw3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        polindrome(keyboard.nextLine());
    }

    private static void polindrome(String text) {
        String text2 = text.replaceAll("\\s", "");
        System.out.println(text2);
        for (int i = 0; i < text2.length() / 2; ++i) {
            if (text2.charAt(i) != text2.charAt(text2.length() - i - 1)) {
                System.out.println("Не палиндром");
            }
        }
        System.out.println("Палиндром");
    }
}
