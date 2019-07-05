package questions;

public class StringReverseUsingSubString {

	public static void main(String[] args) {
		
		String name = "LakshmiRaj";
		System.out.println(getSubString(name));
	}
	
	static String getSubString(String s) {
		
		if(s.isEmpty()) {
			return s;
		}
			return getSubString(s.substring(1)) + s.charAt(0);
		}
	}
