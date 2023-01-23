package com.shabatura.hw15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(21);
        list.add(31);
        list.add(41);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("**************************************");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("**************************************");
        int count = 0;
        while (list.size() > count){
            System.out.println(list.get(count));
            count++;
        }
        System.out.println("**************************************");
        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }
    }
}
