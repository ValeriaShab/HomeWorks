package com.shabatura.hw7;

public class Task2 {
    public static void main(String[] args) {
        Vector[] vectors = Vector.generator(15);
        System.out.println("Вектор 1: " + vectors[0]);
        System.out.println("Вектор 2: " + vectors[1]);
        System.out.println("Длинна вектора: " + vectors[0].getLength());
        System.out.println("Векторное произведение: " + vectors[0].getVectorProduct(vectors[1]));
        System.out.println("Косинус угла между векторами: " + vectors[0].getCos(vectors[1]));
        System.out.println("Сумма векторов: " + vectors[0].getSum(vectors[1]));
        System.out.println("Разность векторов: " + vectors[0].getDif(vectors[1]));
    }
}
