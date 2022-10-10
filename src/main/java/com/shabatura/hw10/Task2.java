package main.java.com.shabatura.hw10;

interface Pow {
    int pow(int number, int pow);
}

public class Task2 {
    public static void main(String[] args) {
        Pow power;
        power = (number, pow) -> {
            int result = 1;
            for (int i = 0; i < pow; i++) {
                result *= number;
            }
            return result;
        };
        System.out.println(power.pow(4, 5));
    }
}
