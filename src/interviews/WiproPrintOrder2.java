package interviews;

public class WiproPrintOrder2 {

//	n = 3
//	1*2*3
//	7*8*9
//	4*5*6
	
	public static void main(String[] args) {
		printThis(3);
		
		
	}
	
	static void printThis(int n) {
		int k = 0;
		String s = "";
		String s2 = "";
		
		for(int i=1; i <= n; i++) {
			
			k = k + n;
			s = "";
				
			for(int j= (k-n) + 1 ; j <= k ; j++) {
				if(i != 2) {
					s += j+"*";
				} else {
					s2 += j+"*";
				}
			}
			
			if(s.length() >0) {
				System.out.println(s.substring(0,s.length()-1));
			}
		}
		
		System.out.println(s2.substring(0,s2.length()-1));
	}
}
