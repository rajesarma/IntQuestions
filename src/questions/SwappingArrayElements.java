package questions;

public class SwappingArrayElements {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		int length = modifyArr(arr, 3);

		for(int i=0; i<length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static int modifyArr(int[] arr, int n) {
		
		int v = 0;
		int k = arr.length - n;
		for(int i = 0; i < arr.length; i++) {
			if(n > 0) {
				v = arr[i]; 
				arr[i] = arr[k];
				arr[k] = v;
			}
			k++;
			n--;
		}
		return arr.length;
	}

}
