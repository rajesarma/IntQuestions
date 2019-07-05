package questions;

import java.util.Arrays;

public class CountingCharacters {

	public static void main(String[] args) {
		char[] chars = {'a','a','b','b','c','c','a','b'};
		
		Arrays.sort(chars);
		
		String output = "";
		char ch = chars[0];
		int count=0;
		for(char c : chars) {
			if (ch == c) {
				count++;
			} else {
				
				output = output + ch + count;
//				System.out.println(ch +""+ count);
				count =1;
			}
			
			ch = c;
		}
//		System.out.println(ch +""+ count);
		output = output + ch + count;
		
		System.out.println(output);
	}

}
