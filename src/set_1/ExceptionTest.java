package set_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionTest {

	
	public static void main(String[] args) {
		
		
		
		List al = new ArrayList<>(Arrays.asList(args) );
		
//		al.add(args);
		
//		/al.get(0)
		
		args[1] = "1";
		
		al.add("ff");
		
		al.add("dd");
		
		al.add("ffss");
		
		
		
		System.out.println(args.length );
		
		
	}
	
}
