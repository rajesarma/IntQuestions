package questions;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovingArrayElements {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4};
		
//		int length = modifyArr(arr, 2);

		/*for(int i=0; i<length; i++) {
			System.out.print(arr[i]+" ");
		}*/
		
	}
	
	static int modifyArr(int[] arr, int n) {
		
		int v = 0;
		int k = arr.length - n;
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = i + (n-1); j < arr.length; j++) {
					
					/*v = arr[j]; 
					arr[i] = arr[j];
					arr[k] = v;*/
				
					v = arr[i]; 
					arr[j] = arr[i];
					arr[k] = v;
					System.out.println(arr[j]);
					
					k++;
					//j--;
				
			}
		}
		
		/*for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}*/
		
		return arr.length;
	}

}
