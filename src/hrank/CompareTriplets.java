package hrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareTriplets {

	public static void main(String[] args) {

//		Complete the function compareTriplets. It must return an array of two integers, the first being Alice's score and the second being Bob's.
//		Comparison points of each person.
		
//		If a[0] > b[0], so Alice receives  point.
//		If a[0] = b[0], so nobody receives a point.
//		If a[0] < b[0], so Bob receives  point.
//		Return an array of two integers denoting the respective comparison points earned by Alice and Bob.
		
//		Using Arrays 
		
		int[] a1 = {17, 28, 30};
		int[] b1 = {99, 16, 8};
		int[] output = new int[2];
		
		for (int index=0; index < a1.length; index++) {
			if(a1[index] > b1[index]) {
				output[0] += 1;
			} else {
				output[1] += 1;
			}
		}
		
		System.out.println(Arrays.toString(output));
		
//		--------------------------
		
//		Using ArrayList
		
		List<Integer> aList = Arrays.asList(17, 28, 30);
		List<Integer> bList = Arrays.asList(99, 16, 8);
		
		List<Integer> oList = new ArrayList<>(Arrays.asList(0,0));
		
		for (int index=0; index < aList.size(); index++) {
			
			if(aList.get(index) > bList.get(index)) {
				oList.set(0, oList.get(0) + 1); 
			} else if(aList.get(index) < bList.get(index) ) {
				oList.set(1, oList.get(1) + 1);
			}
		}
		
		
		System.out.println(oList);
		
//		-----------------------
//		Using List as Input and Array as Output
		
//		Submitted in HRank
		
		List<Integer> a = Arrays.asList(17, 28, 30);
		List<Integer> b = Arrays.asList(99, 16, 8);
		int[] outputArr = new int[2];
		
        for(int index=0; index< a.size(); index++) {
            if(a.get(index) > b.get(index)) {
            	outputArr[0] += 1;
            } else if(a.get(index) < b.get(index) ) {
            	outputArr[1] += 1;
            }
        }

        System.out.println(Arrays.stream(outputArr).boxed().collect(Collectors.toList()) );
		
	}

}
