package generics;

class Gen<T>{
	
	T ob;
	
	Gen(T o){
		this.ob = o;
	}

	public T getOb() {
		return ob;
	}

	void showType(){
		System.out.println("The type value is : "+ ob.getClass().getTypeName() );
		
	}
	
	public String getValue() {
		
		return "Value in Type : "+ob.toString();
	}
}

public class GenericDemo1 {

	public static void main(String[] args) {
		
		Gen<Integer> intOb = new Gen<Integer>(36);
		
		intOb.showType();
		
		int value = intOb.getOb();
		System.out.println("Value is "+value);
		
		Gen<String> strOb = new Gen<String>("Sarma");
		
		strOb.showType();
		
		String strValue = strOb.getOb();
		System.out.println("strOb Value is "+strValue);
		
		// We can not assign one Generic Type Reference to other Type Reference;
		//This improves Type Safety
		
		//If we dont use Generics, Then we have to use Objects, I that case we can assign one reference to other.
		//intOb = strOb can be possible
		//But, In Run time we may get Exception while retriving value because of different types
		// We need explicit cast to convert and retrieve value
		
		//Through generics, run-time errors are converted into compile-time errors
		
		
	}
	
}
