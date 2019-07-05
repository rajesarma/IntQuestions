package hrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxNumberDuplicates {

//	 private static final Scanner scanner = new Scanner(System.in);

	 public static void main(String[] args) throws IOException {
//		 Code to accept data from user input taken from Hacker Rank
		 
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
		 
		 int[] arr = {4,3,4,1,2};
		 
		System.out.println(birthdayCakeCandles(arr));
    }

    static int birthdayCakeCandles(int[] ar) {
    	
    	List<Integer> list = Arrays.stream(ar).boxed().collect(Collectors.toList());
    	
    	return Collections.frequency(list, list.stream().sorted(Collections.reverseOrder()).findFirst().get());
    }
	    

	    
}
