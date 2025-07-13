package com.lakshmi.hrank;

import java.util.Scanner;


public class MathSeriesElements {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		int[][] elements = new int[t][];
		
		for(int i=0; i<t; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int n = scan.nextInt();
			
			//int opElements[] = new int[n];
			elements[i] = new int[n];
			
			for(int j=0; j<n; j++) {
				//opElements[j] = getEval(a, b, j);
				elements[i][j] = getEval(a, b, j);
			}
			
			//elements[i] = opElements;
		}
		
		scan.close();
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<elements[i].length; j++) {
				System.out.print(elements[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	public static int getEval(int a, int b, int n) {
		int result = a;
		for(int k=0; k<=n; k++) {
			result += (Math.pow(2, k) * b);
		}
		return result;
	}
}
