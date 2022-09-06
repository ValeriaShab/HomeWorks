package Lessons.Lesson1;

public class Task6 {
    public static void main(String[] args) {
        int number = 2;
        int exponent = 8;
        System.out.println("Число: " + number + " в степени: " + exponent + " равняется:" + calcExp(2, 8));
    }

    private static int calcExp(int number, int exponent) {
        int result = number;
        if (exponent == 0) {
            return 1;
        }
        for (int i = 2; i <= exponent; i++) {
            result *= number;
        }
        return result;
    }
}
