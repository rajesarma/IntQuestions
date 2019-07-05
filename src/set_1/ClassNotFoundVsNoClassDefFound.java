package set_1;

public class ClassNotFoundVsNoClassDefFound {

	// ClassNotFoundException comes up when there is an explicit loading of class is involved by providing name of class at runtime using ClassLoader.loadClass using Class.forName 
	// while NoClassDefFoundError is a result of implicit loading of class because of a method call from that class or any variable access.
	
	public static void main(String[] args) {
		try {
			//Class.forName("Collections");
			
			// Class cls = Class.forName("java.lang.ClassLoader");
			
			Class cls = Class.forName("java.lang.String1");
			
			System.out.println("Class found = " + cls.getName());
	        System.out.println("Package = " + cls.getPackage());
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
}
