package hrank;

import java.util.Arrays;

public class BigNumbersSum {

//	Calculate and print the sum of the elements in an array, keeping in mind that some of those integers may be quite large.
//	It must return the sum of all array elements.
	
	public static void main(String[] args) {

		long[] arr = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
		
		System.out.println(bigSum(arr));
		
	}
	
	static long bigSum(long[] ar) {
		return Arrays.stream(ar).sum();
	}

}
