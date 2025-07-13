package sample;

import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		int n;
		System.out.println("Enter Matrix Size..");
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		int[][] a= new int[n][n];
		int[][] b= new int[n][n];
		int[][] c= new int[n][n];
		
		System.out.println("Enter elements for First Matrix..");

		for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                a[i][j] = sc.nextInt();
            }
        }
		
		/*for(int i =0; i<n; i++)
		{
			for(int j =0; i<j; j++)
			{
				a[i][j] = sc.nextInt();
			}
		}*/
		
		System.out.println("Enter elements for Second Matrix..");
		
		for(int i =0; i<n; i++)
		{
			for(int j =0; j<n; j++)
			{	
				b[i][j] = sc.nextInt();
			}
		}
		
		for(int i =0; i<n; i++)
		{
			for(int j =0; j<n; j++)
			{
				for(int k =0; k<n; k++)
					c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
			}
				
		}
		
		System.out.println("Multiplied Matrix..");
		
		for(int i =0; i<n; i++)
		{
			for(int j =0; j<n; j++)
			{
				System.out.println(c[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
