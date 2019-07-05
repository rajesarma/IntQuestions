package generics;

class GenClass<T extends Runnable> {
	
}

/*class GenSubClass extends GenClass<Runnable> {
	
}
*/

class GenSubClass extends Thread {
	
}


public class GenericTest1 {

	public static void main(String[] args) {
		
		GenClass<Runnable> gc = new GenClass<Runnable>();
		
		GenClass<Thread> gc1 = new GenClass<Thread>();
		GenClass<GenSubClass> gc2 = new GenClass<GenSubClass>();
		
	}
	
	
}
