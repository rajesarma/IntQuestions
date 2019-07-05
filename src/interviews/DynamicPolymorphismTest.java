package interviews;

	class Employee {
		
	}

	class Poly {
		
		public void method1(Object o) {
			System.out.println("In Object");
		}
		
		public void method1(Employee e) {
			System.out.println("In Employee");
		}
	}
	
	
	class WrapperPoly {
		
		
		public void method1(long l) {
			System.out.println("In Long");
		}
		
		public void method1(int i) {
			System.out.println("In Int");
		}
		
		public void method1(double d) {
			System.out.println("In double");
		}
		
		public void method1(float f) {
			System.out.println("In Float");
		}
	}

public class DynamicPolymorphismTest {

	public static void main(String[] args) {
		Poly poly = new Poly();
		
		poly.method1(null);
		
		poly.method1(new Employee());

		
		WrapperPoly wr = new WrapperPoly();
		
		wr.method1(250000000);
		
		wr.method1(0.0f);
	}

}
