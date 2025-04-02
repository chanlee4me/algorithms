package com.thealgorithm.sort;
import com.thealgorithm.sort.QuickSort;
import org.junit.Test;
import static org.junit.Assert.*; // 静态导入所有断言方法
public class QuickSortTest {

    @Test
    public void testQuickSortWithRandomArray() {
        int[] arr = {5, 3, 9, 1, 6};
        int[] expected = {1, 3, 5, 6, 9};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testQuickSortWithReverseSorted() {
        int[] arr = {9, 7, 5, 3, 1};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    public void testQuickSortWithEmptyArray() {
        int[] arr = {};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        assertEquals(0, arr.length);
    }

    @Test
    public void testQuickSortWithDuplicates() {
        int[] arr = {3, 2, 3, 1, 2};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        assertArrayEquals(new int[]{1, 2, 2, 3, 3}, arr);
    }
}
