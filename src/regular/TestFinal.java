package regular;

public class TestFinal {

	public static void main(String[] args) {
		
		A a = new A(new B("Testing"));
//		a.printing();

	}
}

class A{
	
	private final B b = null;
	
	A (B b) {
		System.out.println("In Constructor");
//		this.b = new B("Test");
		System.out.println(this.b.toString());
	}
}

class B{
	
	private String name;
	B(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "B [name=" + name + "]";
	}
	
	
	
}
