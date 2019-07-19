package set_1;

public class SwitchTest {
	static public long i=10;
	
	public static void main(String argv[])
	{
		SwitchTest ms= new SwitchTest();
		 ms.amethod();
		// Switch can take only int, string, enum values
		// So the following code will not work
		/*switch(i)
		{
			default:
			System.out.println("no value given");
			case 1:
			System.out.println("one");
			case 10:
			System.out.println("ten");
			case 5:
			System.out.println("five");
		}*/
		
	}
	  
	public void amethod()
	{
		int k=10;
		        
		switch(k) {
			
			default: //Put the default at the bottom, not here
				System.out.println("This is the default output");
				break;
			case 10:
				System.out.println("ten");
				break;
			case 20:
				System.out.println("twenty");
				break;
				
		}
	}
	
	// We can place default any where in the switch block
	
	
	
}
