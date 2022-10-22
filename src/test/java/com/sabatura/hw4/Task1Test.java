package test.java.com.sabatura.hw4;

import com.shabatura.hw4.Task1;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class Task1Test {
    private final int[] array = {2, 3, 4};
    private final int[] array2 = {1, 1, 1};

    @Test
    public void findArithmeticalMeanTest() {
        Assertions.assertEquals(3, Task1.findArithmeticMean(array));
        Assertions.assertEquals(1, Task1.findArithmeticMean(array2));
    }

    @Test
    public void findGeometricMeanTest() {
        Assertions.assertEquals(2.8844992316817106, Task1.findGeometricMean(array));
        Assertions.assertEquals(1, Task1.findGeometricMean(array2));
    }
}