package collections;

import java.util.Scanner;


public class Combinations 
{
	static int[][] childsGiftsArray;
	static int[] childsGiftsSubArray;
	static Scanner sc=null;
	public static void main(String[] args)
	{
		int childCount, giftCount;
		Scanner sc=null;
		System.out.println("Enter Child count ..");
		sc=new Scanner(System.in);
		childCount=sc.nextInt();
		
		System.out.println("Enter Gift count ..");
		sc=new Scanner(System.in);
		giftCount=sc.nextInt();
		
		createArray(childCount,giftCount);
		assignValues(childCount, giftCount);
		displayValues(childCount, giftCount);
		displayPermutationValues(childCount, giftCount);
	}
	
	private static void createArray(int childCount, int giftCount) 
	{
		childsGiftsArray = new int[childCount][giftCount];
		
		for(int iterator = 0; iterator < childCount; iterator++) 
		{
			childsGiftsArray[iterator] = new int[giftCount];
		}
	}
	
	private static void assignValues(int childCount, int giftCount) 
	{
		sc=new Scanner(System.in);
		int giftValue=1;
		for(int childIterator = 0; childIterator < childCount; childIterator++) 
		{
			for(int giftIterator = 0; giftIterator < giftCount; giftIterator++)
			{
				System.out.println("Enter Gift Rank for G"+(giftValue++));
				
				childsGiftsArray[childIterator][giftIterator] = sc.nextInt();
			}
		}
	}
	
	private static void displayValues(int childCount, int giftCount) 
	{
		System.out.println("Gift Ranking by each child.. ");
		for(int childIterator = 0; childIterator < childCount; childIterator++) 
		{
			for(int giftIterator = 0; giftIterator < giftCount; giftIterator++)
			{
				//System.out.print("Child "+(childIterator+1)+ " : " +childsGiftsArray[childIterator][giftIterator] + "   ");
				System.out.print(" ["+childsGiftsArray[childIterator][giftIterator] + "] ");
			}
			System.out.println(" ");
		}
	}
	
	private static void displayPermutationValues(int childCount, int giftCount) 
	{
		System.out.println(" Possible Combinations are... ");
		for(int childIterator = 0; childIterator < childCount; childIterator++) 
		{
			childsGiftsSubArray = childsGiftsArray[childIterator];
			permute(childsGiftsSubArray, 0);
		}
	}
	
	private static void permute(int[] a, int k) 
    {
        if (k == a.length) 
        {
            for (int i = 0; i < a.length; i++) 
            {
                System.out.print(" [" + a[i] + "] ");
            }
            System.out.println();
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
	
}
