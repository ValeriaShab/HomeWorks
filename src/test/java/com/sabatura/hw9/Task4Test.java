package test.java.com.sabatura.hw9;

import main.java.com.shabatura.hw9.Task4;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

 public class Task4Test {
  private final double[] array = {1001, 200, 3000, 300, 10000};
  private final double[] arrayLessThan1000 = {100, 200, 300, 400};

  @Test
  public void costOfAllProductsOverThousandTest() {
   Assertions.assertEquals(14001, Task4.costOfAllProductsOverThousand(array));
   Assertions.assertEquals(0, Task4.costOfAllProductsOverThousand(arrayLessThan1000));
  }
}