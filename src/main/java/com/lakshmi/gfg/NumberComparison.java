package com.lakshmi.gfg;

import java.util.Scanner;

public class NumberComparison {

	public static void main(String[] args) {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		int noOfTimes = sc.nextInt();
		
		int i;
		float f;
		String s;
		
		for (int k = 0; k < noOfTimes; k++) {
		    i = sc.nextInt();
		    sc.nextLine();
		    s = sc.nextLine();
//		    sc.next();
		    f = sc.nextFloat();
		    
		    System.out.println(i + " " + s + " " + f);
		}
		sc.close();
		
		/*int  a, b;
		
		for (int i = 0; i < noOfTimes; i++) {
	        a = sc.nextInt();
	        b = sc.nextInt();
			System.out.println( (a > b ? "greater" : ( b > a ? "lesser" : "equal" ) ) );
	    }*/
		
		/*try {
		    
		    // times = Integer.parseInt(br.readLine());
		    
		    for (int i = 0; i < times; i++) {
		        a = Integer.parseInt(br.readLine());
		        b = Integer.parseInt(br.readLine());
//				System.out.println( (a > b ? "greater" : ( b > a ? "lesser" : "equal" ) ) );
		    }
		    
		    br.close();
		} catch (IOException io) {
		    
		} catch(Exception e) {
		    
		}*/
		
		

	}

}
