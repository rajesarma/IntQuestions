package questions;



public class FuncTest {

	public static void main(String[] args) {
		
		FuncInterface f = (s) -> { System.out.println(s);};
		
		f.printThis("Printing this");
		
	}
}
