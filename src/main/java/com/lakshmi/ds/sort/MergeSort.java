package com.lakshmi.ds.sort;

public class MergeSort {

    // Time Complexity
    // Worst Case : O(nlogn)
    // Average Case : O(nlogn)
    void sort(int[] arr, int left, int right) {
        divideAndMerge(arr, left, right);
    }

    void divideAndMerge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        divideAndMerge(arr, left, mid);
        divideAndMerge(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    void merge(int[] arr, int low, int mid, int high) {
        int[] mergeArr = new int[high - low + 1];

        int index1 = low;
        int index2 = mid + 1;
        int x = 0;

        while(index1 <= mid && index2 <= high) {
            if (arr[index1] <= arr[index2]) {
                mergeArr[x++] = arr[index1++];
            } else {
                mergeArr[x++] = arr[index2++];
            }
        }

        // Copy remaining elements of L[] if any
        while (index1 <= mid) {
            mergeArr[x++] = arr[index1++];
        }

        // Copy remaining elements of R[] if any
        while (index2 <= high) {
            mergeArr[x++] = arr[index2++];
        }

        for (int i = 0, j=low; i < mergeArr.length; i++, j++) {
            arr[j] = mergeArr[i];
        }
    }
}
