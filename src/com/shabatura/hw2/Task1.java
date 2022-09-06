package com.shabatura.hw2;

public class Task1 {
    public static void main(String[] args) {
        calcSquare(5, 4, 8, 1, 2, 3);
    }

    private static void calcSquare(int x1, int x2, int x3, int y1, int y2, int y3) {
        double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double c = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        if (a + b <= c || a + c <= b)
            System.out.println("Треугольник не существует");
        else {
            double p = (a + b + c) / 2.0;
            double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Square = " + square);
        }
    }
}
