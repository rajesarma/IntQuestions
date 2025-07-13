package com.lakshmi.ds.sort;

public class InsertionSort {
    // Time Complexity
    // Worst case : O(n^2)
    // Average case : O(n^2)

//    sorted | unsorted
//    7 | 8 2 1 3
    void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 2
            int current = arr[i]; // 2
            int j = i-1; // 1
            while (j >= 0 && current < arr[j]) { // 2 < 8
                arr[j+1] = arr[j]; // 2 pos -> 8
                j--; // 0
            }
            // placement
            arr[j+1] = current; // 1 -> 8
        }
    }
}
