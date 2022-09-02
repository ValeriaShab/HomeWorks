package com.shabatura.hw1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task1 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("________________________");
        System.out.println("Shabatura Valeria");
        System.out.println(formatter.format(date));
        System.out.println("________________________");
    }
}
