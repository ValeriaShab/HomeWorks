package com.shabatura.hw14.Task1;

import java.util.Arrays;

public class MySet<T> {
    private final T[] array;

    public MySet (T[] array){
        this.array = array;
    }

    private void add(T t){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == t){
                break;
            } else if (array[i] == null){
                array[i] = t;
                break;
            }
        }
    }

    private T get(int index){
        return array[index];
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MySet<Integer> mySet = new MySet<>(new Integer[5]);
        mySet.add(2);
        mySet.add(3);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        mySet.add(6);
        System.out.println(mySet);
        System.out.println(mySet.get(3));
    }
}
