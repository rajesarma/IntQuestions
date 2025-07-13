package interviews.mphasis;

public class RuntimeCheck {

	static void test() throws RuntimeException {
		try {
			System.out.print("test ");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.print("Exception ");
		}
	}
	
	public static void main(String[] args) {
		try {
			test();
		} catch (RuntimeException e) {
			System.out.print("Runtime Exception ");
		}
		
		System.out.print("end ");
	}
}
