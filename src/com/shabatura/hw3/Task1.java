package com.shabatura.hw3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String text = keyboard.nextLine();
        System.out.println(deleteSpaces(text));
        palindrome(deleteSpaces(text));
    }

    private static String deleteSpaces(String text) {
        String text2 = text.replaceAll("\\s", "");
        return text2;
    }

    private static void palindrome(String text) {
        for (int i = 0; i < text.length() / 2; ++i) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                System.out.println("Не палиндром");
            }
        }
        System.out.println("Палиндром");
    }
}
