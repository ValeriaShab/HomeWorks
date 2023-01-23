package com.shabatura.hw14.Task2;

import java.util.Arrays;

public class Utilit {
    public static <T> void print(T t){
        System.out.println("***{"+ t + "}***");
    }

    public <T> void printArray(T[] array){
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Utilit utilit = new Utilit();
        Integer[] integers = {2,3,4,5,6};
        print(5);
        utilit.printArray(integers);
    }
}
