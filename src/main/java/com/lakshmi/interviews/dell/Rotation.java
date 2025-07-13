package com.lakshmi.interviews.dell;

public class Rotation {
    public static void main(String[] args) {
        // iLakshm -> 1 8
        // miLaksh -> 2
        // himLaks -> 3
        int num = 4;
        if (num < 0) {
            throw new IllegalArgumentException("Rotation character count cannot be negative!");
        }

        String s = "Lakshmi";
        if (num > s.length()) {
            num = num % s.length();
        }
        /*char[] sArray = s.toCharArray();
        int length = modifyArr(sArray, num);

        for (int i = 0; i < length; i++) {
            System.out.print(sArray[i] + " ");
        }
        */

        System.out.println(rotateString(s, num));
    }

    static String rotateString(String s, int num) {
        int len = s.length();
        int n = num % len;
        if (n == 0) {
            return s;
        }
//        n = forward ? n : len - n;
        return s.substring(len - n, len) + s.substring(0, len - n);
    }

    private static int modifyArr(char[] arr, int n) {

        char[] secondArr = new char[arr.length];

        for (int i = arr.length - n; i < arr.length; i++) {
            secondArr[i] = arr[i];
        }

        for (int i = arr.length - 1; (i - n) >= 0; i--) {
            arr[i] = arr[i - n];
        }
        for (int i = 0; i < arr.length - n; i++) {
            if (i < n) {
                arr[i] = secondArr[i + arr.length - n];
            }
        }

        return arr.length;
    }
}

    /*private static int modifyArr(char[] arr, int n) {

        char[] firstArr = new char[arr.length];
        char[] secondArr = new char[arr.length];

        for(int i = 0; i < arr.length - n; i++) {
            firstArr[i] = arr[i];
        }

        for(int i = arr.length - n ; i < arr.length; i++) {
            secondArr[i] = arr[i];
        }

        for(int i=0; i<firstArr.length; i++) {
            if(i < n) {
                arr[i] = secondArr[i + arr.length - n];
            } else {
                arr[i] = firstArr[i - n];
            }
        }

        return arr.length;
    }*/

/*
    public static void main(String[] args) {

    if (num > s.length()) {
            num = num % s.length();
        }

        if (num > 0) {
            String subString = s.substring(0, s.length() - num);
            String s4 = s.replace(subString, "");
            s = s4 + subString;
        }
        System.out.println(s);*/

        /*int l = s.length();
        char[] sArray = s.toCharArray();
        char temp;

          int j =0;
          for (int i = s.length() -1 ; i > 0; i--) {
              temp = sArray[i];

              if(i > 0) {
                  sArray[j] = sArray[i];
              }
              if(i == 0) {
                  sArray[i] = temp;
              }
              j ++;
          }
          for (char c: sArray) {
              System.out.print(c);
          }
    } */