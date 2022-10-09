package test.java.com.sabatura.hw9;

import org.junit.jupiter.api.Assertions;
import main.java.com.shabatura.hw9.Task1;
import org.junit.Test;

public class Task1Test {
    int[] trueArray = {5, 4, 3, 2, 1};
    int[] falseArray = {1, 2, 3, 4, 5};

    @Test
    public void checkIsTrue() {
        Assertions.assertTrue(Task1.checkArray(trueArray));
    }

    @Test
    public void checkIsFalse() {
        Assertions.assertFalse(Task1.checkArray(falseArray));
    }
}


