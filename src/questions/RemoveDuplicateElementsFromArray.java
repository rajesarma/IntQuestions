package questions;

public class RemoveDuplicateElementsFromArray {

	public static void main(String[] args) {
		
//		int[] arr = {10,20,20,30,30,40,50,50};
		
		int[] arr = {1,2,2,1,3};
		
		int length = modifyArr(arr, arr.length);
		
		for(int i=0; i<length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static int modifyArr(int[] arr, int n) {
		
		int j =0 ;
		
		for(int i=0; i<n; i++) {
			for(j=i+1; j<n; j++) {
				
				if(arr[i] == arr[j]) {
					arr[j] = arr[n-1];
					n--;
					j--;
				}
			}
		}
		return j;
	}

}
