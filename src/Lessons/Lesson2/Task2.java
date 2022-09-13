package Lessons.Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        double[] costs = new double[12];
        fillRandomArray(costs);
        System.out.println(Arrays.toString(costs));
        System.out.printf("Sum = %.2f %n", costOfAllProductsUnderThousand(costs));
    }

    private static void fillRandomArray(double[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble() * 2000;
        }
    }

    private static double costOfAllProductsUnderThousand(double[] costs) {
        if (costs.length == 0) {
            throw new RuntimeException("array has size 0.");
        }
        double sum = 0;
        for (double cost : costs) {
            if (cost >= 1000) {
                sum += cost;
            }
        }
        return sum;
    }
}
