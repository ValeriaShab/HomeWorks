package test.java.com.sabatura.hw5;

import com.shabatura.hw5.Practice1;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Practice1Test {
    private final int[] heights1 = {160, -160, 150, -150, 170, -170};
    private final int[] heightsGirls = {160, 150, 170};
    private final int[] heightsBoys = {-160, -150, -170};

    @Test
    public void getAvgBoyHeightTest() {
        Assertions.assertEquals(160, Practice1.getAvgBoyHeight(heights1));
        Assertions.assertEquals(0, Practice1.getAvgBoyHeight(heightsGirls));
    }

    @Test
    public void getAvgGirlHeightTest() {
        Assertions.assertEquals(160, Practice1.getAvgGirlHeight(heights1));
        Assertions.assertEquals(0, Practice1.getAvgGirlHeight(heightsBoys));
    }
}