package test.java.com.sabatura.hw9;

import main.java.com.shabatura.hw9.Task3;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Task3Test {
    private final int[] heights1 = {160, -160, 150, -150, 170, -170};
    private final int[] heightsGirls = {160, 150, 170};
    private final int[] heightsBoys = {-160, -150, -170};

    @Test
    public void getAvgBoyHeightTest() {
        Assertions.assertEquals(160, Task3.getAvgBoyHeight(heights1));
        Assertions.assertEquals(0, Task3.getAvgBoyHeight(heightsGirls));
    }

    @Test
    public void getAvgGirlHeightTest() {
        Assertions.assertEquals(160, Task3.getAvgGirlHeight(heights1));
        Assertions.assertEquals(0, Task3.getAvgGirlHeight(heightsBoys));
    }
}