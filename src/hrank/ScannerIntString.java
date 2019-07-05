package hrank;

import java.util.Scanner;

public class ScannerIntString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int i = scan.nextInt();
		double d = scan.nextDouble();
		scan.nextLine();
		String s= scan.nextLine();
		
		System.out.println("String: "+s);
		System.out.println("String: "+d);
		System.out.println("String: "+i);
		
	}
	
}
