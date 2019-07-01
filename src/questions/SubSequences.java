package questions;

public class SubSequences {

	
	static String[] findSubSequences(String s) {
		
		if(s.length() == 0) {
			String[] ans = {""};	 
			return ans;		
		}
		
		String smallAns[] = findSubSequences(s.substring(1));
		String ans[] = new String [2 * smallAns.length];
		
		int k =0;
		for(int i = 0; i < smallAns.length; i++) {
			ans[k] = smallAns[i];
			k++;
		}
		
		for(int i = 0; i < smallAns.length; i++) {
			ans[k] = s.charAt(0) + smallAns[i];
			k++;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "xyz";
		
//		System.out.println(s.substring(1));
		
		String ans[] = findSubSequences(s);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
