package oca;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class MultipleMainMethods4 {

//	Which of the following main methods used to print second and fourth parameters 
	/*public static void main(String... method) {
		
		for (int i = 1; i<method.size && i < 6; i = i+2 )
			System.out.println(args[i]);
	}*/
	
	/*public static void main(String[] main) {
		
		for (int i = 1; i<main.length && i < 6; i = i+2 )
			System.out.println(main[i]);
	}*/
	
	public static void main(String... arguments) {
		
		int ctr = 0 ;
		while(ctr<arguments.length) {
			if(ctr >= 4) break;
			
			if(ctr %2 !=0)
				System.out.println(arguments[ctr]);
			++ctr;
		}
		
		
		Map tMap = new HashMap();
		
	}
	
	/*public static void main(String[] arguments) {
		
		int ctr = 1 ;
		while(ctr<arguments.length) {
			if(ctr >= 4) break;
			
			if(ctr %2 ==0)
				System.out.println(arguments[ctr]);
			++ctr;
		}
	}*/
	
	
}
