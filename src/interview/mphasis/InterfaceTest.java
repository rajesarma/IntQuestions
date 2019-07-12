package interview.mphasis;

import questions.Test1;

interface TestA {
	String toString();
}

public class InterfaceTest {

	public static void main(String[] args) {
		
		System.out.println(new TestA() {
			public String toString() {
				return null;
			}
		});
	}

}
