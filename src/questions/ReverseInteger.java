package questions;

public class ReverseInteger {

	public static void main(String[] args) {
		
		System.out.println(reverse(1534236469));

	}
	
	
	 public static int reverse(int x) {
		 /*long number = 1534236469;
			Long num = number;
			Long rev = 0L;
			Long n = 0L;
			
			if(number < 0) {
				num = -num;
			}
			
			while(num > 0) {
				n = num % 10;
				rev = (rev * 10) + n ;
				num = num / 10;
			}
			
			if(number < 0) {
				rev = -rev;
			}
			
			return rev.intValue();*/
		 
		 StringBuffer s = new StringBuffer(x+"");
		 
		 StringBuffer s1 = s.reverse();
		 System.out.println(s1.toString());
		 String s2 = s1.toString();
		 
		 return Integer.valueOf(s2);
		 
	 }

}
