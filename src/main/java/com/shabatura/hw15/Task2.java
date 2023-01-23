package com.shabatura.hw15;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static int getSum(List<Integer> numbers){
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }

    public static List<Integer> getOddNumbers (List<Integer> numbers){
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i : numbers) {
            if (i % 2 != 0) {
                odd.add(i);
            }
        }
        return odd;
    }

    public static List<String> convertToStringList ( List<Integer> numbers ){
        List<String> stringList = new ArrayList<>(numbers.size());
        for (Integer number : numbers) {
            stringList.add(String.valueOf(number));
        }
        return stringList;
    }

    public static List<String> doubling ( List<String> strings ){
        ArrayList<String> doubling = new ArrayList<> ( );
        for (String str : strings) {
            str = str + str;
            doubling.add ( str );
        }
        return doubling;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        System.out.println(getSum(numbers));
        System.out.println(getOddNumbers(numbers));
        System.out.println(convertToStringList(numbers));
        System.out.println(doubling(convertToStringList(numbers)));
    }
}
