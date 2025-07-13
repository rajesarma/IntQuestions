package sample;

public class ExitClass {
	public static void main(String[] args) {
		
		
		try{
			
			System.out.println("Start");
			
			System.exit(0);
			
			System.out.println("Here");
			
		}
		catch (Exception e) {
			System.out.println("catch");
			
			
		}
		finally{
			System.out.println("finally");
			
		}
		
		
	}
}
