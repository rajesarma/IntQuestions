package questions;

public class AddStrings {

	// Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
	
	public static void main(String[] args) {
		
		System.out.println(addStrings("6913259244","71103343"));
	}

	public static String addStrings(String num1, String num2) {
        String output="";
        
        long num1Sum = 0;
        for(int i =0; i<num1.length(); i++) {
        	num1Sum *= 10;
        	num1Sum = num1Sum +(int)num1.charAt(i) - (int)'0'; 
        }
        
        long num2Sum = 0;
        for(int i =0; i<num2.length(); i++) {
        	num2Sum *= 10;
        	num2Sum = num2Sum +(int)num2.charAt(i) - (int)'0'; 
        }
        
        //System.out.println(num1Sum + num2Sum);
        output = String.valueOf(num1Sum + num2Sum);
        
		return output;
    }
	
	
	class MyBig {

		   int[] num = new int[100];

		   void add(MyBig other) {

		      for(int i = 100; --i > 0;) {
		         num[i] += other.num[i];
		         num[i+i] += num[i] % 10;
		         num[i] = 10;
		      }
		    }

		 

		    public String toString() {

		       StringBuilder str = new StringBuilder(100);
		       int i;
		       for(i = 100; --i > 0;) {
		          if(num[i] != 0)
		             break;
		       }

		       for(; i >=0; --i)
		          str.append(num[i]);
		       return str.toString();

		    }
		}
	}
