package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class ReadingInput {
	public static void main (String[] args) {
		int T;
		String s = "";
    
		/*Scanner sc = new Scanner(System.in);
		int noOfTimes = sc.nextInt();
	
		for(int i = 0; i < noOfTimes; i++) {
	        sc.nextLine();
	        s = sc.nextLine();
		    T = sc.nextInt();
	        
	        System.out.println("The input string :"+s);
	        System.out.println("The input integer :"+T);
	    }
		
		sc.close();	*/
	
		/// Using Buffered Reader
		// Java.io.BufferedReader class reads text from a character-input stream, buffering characters so as to provide for the efficient reading of sequence of characters
		// There is an issue with Scanner when nextLine() is used after nextXXX()
		
		// In Scanner class if we call nextLine() method after any one of the seven nextXXX() method then the nextLine() doesn’t not read values from console 
		// and cursor will not come into console it will skip that step. The nextXXX() methods are nextInt(), nextFloat(), nextByte(), nextShort(), nextDouble(), nextLong(), next().
		// If we use one more call of nextLine() method between nextXXX() and nextLine(), then this problem will not occur because nextLine() will consume the newline character.
		// 
		
		// BufferedReader Advantages
		// BufferedReader is synchronous while Scanner is not. BufferedReader should be used if we are working with multiple threads.
		// BufferedReader has significantly larger buffer memory than Scanner.
		// The Scanner has a little buffer (1KB char buffer) as opposed to the BufferedReader (8KB byte buffer), but it’s more than enough.
		// BufferedReader is a bit faster as compared to scanner because scanner does parsing of input data and BufferedReader simply reads sequence of characters.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int num;
		try {
			
			num = Integer.parseInt(br.readLine());
		
			for(int i = 0; i < num; i++) {
		        
				s = br.readLine();
			    T = Integer.parseInt(br.readLine());
		        
		        System.out.println("The input string :"+s);
		        System.out.println("The input integer :"+T);
		    }
			br.close();	
			
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
	
	}
}