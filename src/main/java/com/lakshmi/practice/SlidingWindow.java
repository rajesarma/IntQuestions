package com.lakshmi.practice;

public class SlidingWindow {

  public static void main(String[] args) {

//    int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
    int[] arr = {5, 2, -1, 0, 3};
    int k = 4;
    System.out.println(maxSum(arr, k));
  }

  public static int maxSum(int[] arr, int num) {

    if (arr.length < num) {
      return -1;
    }
    int len = arr.length;
    /*
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < len - num + 1; i++) {
      int currentSum = 0;
      for (int j = 0; j < num; j++) {
        currentSum = currentSum + arr[i + j];
      }
      maxSum = Math.max(currentSum, maxSum);
    }*/

    int maxSum = 0;
    for (int i = 0; i < num; i++) {
      maxSum += arr[i];
    }

    // Compute sums of remaining windows by removing first element of previous window and adding
    // last element of current window.
    int windowSum = maxSum;
    for (int i = num; i < len; i++) {
      windowSum += arr[i] - arr[i - num];
      maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
  }
}
