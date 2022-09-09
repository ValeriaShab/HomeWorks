package com.shabatura.hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        calcWords(keyboard.nextLine());

    }

    private static void calcWords(String text) {
        int count = 0;
        if (text.length() != 0){
            count++;
            for (int i = 0; i < text.length(); i++){
                if (text.charAt(i) == ' '){
                    count++;
                }
            }
        }
        System.out.println("Введено: "+ count + " слов");
    }
}
