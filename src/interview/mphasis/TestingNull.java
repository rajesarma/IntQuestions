package interview.mphasis;

public class TestingNull {

	public static void test(String str) {
		if(str == null | str.length() == 0) {
			System.out.println("String is empty");
		} else {
			System.out.println("String is not empty");
		}
	}
	
	public static void main(String[] args) {
		
		test(null);
	}

}
