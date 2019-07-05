package hrank;

import java.util.Scanner;

public class MathTableUsingLoop {

	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int N = scan.nextInt();
		scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for(int i=1; i<=10; i++) {
			
			System.out.println(N + " X " + i + " = "+ (N*i) );
		}
		
		scan.close();

	}

}
