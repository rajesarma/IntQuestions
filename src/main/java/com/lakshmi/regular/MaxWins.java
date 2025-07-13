package com.lakshmi.regular;

public class MaxWins {
    public static void main(String[] args) {
        int[] arr1 = {3, 6, 7, 5, 3, 5, 6, 2, 9, 1};
        int[] arr2 = {2, 7, 0, 9, 3, 6, 0, 6, 2, 6};
        int max = 0;
        int n;
        for (int i = 0; i < arr1.length; i++) {
            int tempMax = 0;
            n = (i == 0) ? 0 : 1;
            int length = modifyArr(arr1, n);
            for (int j = 0; j < length; j++) {
                if(arr1[j] > arr2[j]) {
                    tempMax++;
                }
            }
            if(tempMax > max) {
                max = tempMax;
            }
        }
        System.out.println("Max wins : " + max);
    }

    static int modifyArr(int[] arr, int n) {
        int[] newArr = new int[n];
        int k = arr.length - n;
        int j;
        for (int i = 0; i < arr.length; i++) {
            j = i + n;
            if(i < k) {
                if(i < n) {
                    newArr[i] = arr[i];
                }
                arr[i] = arr[j];
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            arr[k] = newArr[i];
            k++;
        }
        return arr.length;
    }
}
