package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindSmall3NumsOfArray {

	public static void main(String[] args) {
		
		int[] nums = {10,5,2,8,3,6,4, 4};
		
		// Since if we sort on the original array, it will change the contents
		
		int[] copy = Arrays.copyOf(nums, nums.length);
		
		Arrays.sort(copy);
		
		for(int i=0; i< 3; i++){
			System.out.println(copy[i]);
		}
		
		
		//Using Stream
		IntStream.of(nums)	//		<---------- Create
				.distinct() //	| 
				.sorted()	//	|	<---------- Process
				.limit(3)	//	|
				.forEach(System.out :: println);	//	<--------- Consume 
		// Original array is not mutated
		
		
	}

}
