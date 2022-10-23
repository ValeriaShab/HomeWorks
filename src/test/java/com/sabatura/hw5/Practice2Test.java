package test.java.com.sabatura.hw5;

import com.shabatura.hw5.Practice2;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Practice2Test {
    private final double[] array = {1001, 200, 3000, 300, 10000};
    private final double[] arrayLessThan1000 = {100, 200, 300, 400};

    @Test
    public void costOfAllProductsOverThousandTest() {
        Assertions.assertEquals(14001, Practice2.costOfAllProductsOverThousand(array));
        Assertions.assertEquals(0, Practice2.costOfAllProductsOverThousand(arrayLessThan1000));
    }
}