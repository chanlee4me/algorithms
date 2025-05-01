package com.thealgorithm.sort;

public class BubbleSort {
    public void sort(int[] arr){
        //升序排序
        for (int end = arr.length - 1; end > 0; end--) {
            int flag = 0;
            for (int i = 0; i < end; i++) {
                if(arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                    flag = 1;
                }
            }
            if(flag == 0) return;
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
