package interview.mphasis;

public class TernaryTest {

	public static void main(String[] args) {
		Integer i = 42;
		String s = (i < 40) ? "life":  (i > 50) ? "universe" : "everything"; 
		System.out.println(s);
	}
}
