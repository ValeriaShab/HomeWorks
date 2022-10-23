package test.java.com.sabatura.hw5;

import com.shabatura.hw5.Task2;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Task2Test {
    int[] trueArray = {5, 4, 3, 2, 1};
    int[] falseArray = {1, 2, 3, 4, 5};

    @Test
    public void checkIsTrue() {
        Assertions.assertTrue(Task2.checkArray(trueArray));
    }

    @Test
    public void checkIsFalse() {
        Assertions.assertFalse(Task2.checkArray(falseArray));
    }
}