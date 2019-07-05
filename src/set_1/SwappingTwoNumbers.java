package set_1;

public class SwappingTwoNumbers {

	
	public static void main(String[] args) {
		int a = 20;
//		int b = 10;
		int b = Integer.MAX_VALUE;
		/*a = (a+b) - (b=a);
		System.out.println(a);
		System.out.println(b);*/
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println(a);
		System.out.println(b);
		
	}
	
}
