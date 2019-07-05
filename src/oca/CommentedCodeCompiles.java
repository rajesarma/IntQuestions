package oca;

public class CommentedCodeCompiles {

	public static void main(String... args) {
		System.out.println("Hi Guys!");
		//Character myChar = new Character('\u000d');
   }
}

//In our code, the when Java compiler encounters, it considers this as a newline.
//In the above Java code, look at line 5. It starts with a single quote and there is no following ending quote. 
//Single quote is for declaring a character literal and so we get the error ‘unclosed character literal’ from the Java compiler.