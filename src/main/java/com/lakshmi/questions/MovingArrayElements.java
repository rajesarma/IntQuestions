package com.lakshmi.questions;

public class MovingArrayElements {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		int length = modifyArr(arr, 3);

		for(int i=0; i<length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static int modifyArr(int[] arr, int n) {
		
		int[] newArr = new int[n];
		int k = arr.length - n;
		int j =0;
		for(int i = 0; i < arr.length; i++) {
			j = i + n;
			if(i < k ) {
				if(i < n) {
					newArr[i] = arr[i];
				}
				arr[i] = arr[j];
				
			}
		}
		
		for(int i = 0; i < newArr.length; i++) {
			arr[k] = newArr[i];
			k++;
		}
		
		
		return arr.length;
	}

}
