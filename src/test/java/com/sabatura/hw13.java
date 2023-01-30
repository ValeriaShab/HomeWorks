package com.sabatura;

import com.shabatura.hw13.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class hw13{
    int[] unSortedArray = {5,3,4};
    int[] sortedArray = {3,4,5};

    @Test
    void bubbleSortTest() {
        Assertions.assertArrayEquals(sortedArray, Main.bubbleSort(unSortedArray));
    }

    @Test
    void binarySearchFoundTest() {
        Assertions.assertEquals(2, Main.binarySearch(sortedArray, 5));
    }

    @Test
    void binarySearchNotFoundTest() {
        Assertions.assertEquals(-1, Main.binarySearch(sortedArray, 7));
    }
}
