package questions;

import java.util.HashMap;
import java.util.Map;

public class RomanToEnglish {
	
	public static void main(String[] args) {

		String roman = "VIII";
		
		char[] romanChars = roman.toCharArray();
		int englishValue = 0;

		Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
		
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		int previousValue = 0;
		int presentValue = 0;
		
		for(int i = romanChars.length -1; i >= 0 ; i-- ) {
			
			presentValue = romanMap.get(romanChars[i]).intValue();
//			presentValue = convertToEnglish(String.valueOf(romanChars[i]));
			
			if(presentValue < previousValue ) {
				englishValue -= presentValue;
				
			} else if(presentValue >= previousValue) {
				englishValue += presentValue;
			}
				
			previousValue = presentValue;
		}
			
		System.out.println("englishValue : "+englishValue);
	}
	
	
//	presentValue = convertToEnglish(String.valueOf(ch));
	
	static int convertToEnglish(String romanValue) {
		
		int value;
		
		switch(romanValue) {
			
			case "I" : { 
				value = 1;
				break;
			}
			case "V" : { 
				value = 5;
				break;
			}
			
			case "X" : { 
				value = 10;
				break;
			}
			
			case "L" : { 
				value = 50;
				break;
			}
			
			case "C" : { 
				value = 100;
				break;
			}
			
			case "D" : { 
				value = 500;
				break;
			}
			
			case "M" : { 
				value = 1000;
				break;
			}
			
			default : {
				value = 0;
				break;
			}
		}
		
		return value;
	}
	

}
