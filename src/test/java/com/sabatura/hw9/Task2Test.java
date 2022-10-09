package test.java.com.sabatura.hw9;

import main.java.com.shabatura.hw9.Task2;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


 public class Task2Test {
    private final int[] array = {2, 3, 4};
    private final int[] array2 = {1, 1, 1};

    @Test
    public void findArithmeticalMeanTest() {
        Assertions.assertEquals(3, Task2.findArithmeticMean(array));
        Assertions.assertEquals(1, Task2.findArithmeticMean(array2));
    }

    @Test
    public void findGeometricMeanTest() {
        Assertions.assertEquals(2.8844992316817106, Task2.findGeometricMean(array));
        Assertions.assertEquals(1, Task2.findGeometricMean(array2));
    }
}

