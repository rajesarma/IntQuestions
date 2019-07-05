package interviews;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WiproPrintOrder1 {

//	n = 3
//	333
//	313
//	323
//	333
	
	public static void main(String[] args) {
		printThis(3);
	}
	
	static void printThis(int n) {
		
		int midValue = (n / 2) + 1 ;
		
		for(int i=0; i <= n; i++) {
			
			
			for(int j= 1 ; j <= n ; j++) {
				
				if(i == 0) {
					System.out.print(n);
					
				} else {
					
					if(j == midValue) {
						System.out.print(i);
					} else {
						
						System.out.print(n);
					}
				}
			}
			System.out.println();
		}
	}
	
	
	
	
}
