package set_1;

public class StringConditionsTest {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		if(s1 == s2)
		System.out.println(1);
		else
		System.out.println(2);
		if(s1.equals(s2))
		System.out.println(3);
		else
		System.out.println(4);
		
		// Above Output is 1 and 3
		
		
		String s3 = new String("abc");
		String s4 = new String("abc");
		if(s3 == s4)
		System.out.println(1);
		else
		System.out.println(2);
		if(s3.equals(s4))
		System.out.println(3);
		else
		System.out.println(4);

		// Above Output is 2 and 3
		
	}

}
