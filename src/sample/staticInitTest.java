package sample;

import java.util.Scanner;

public class staticInitTest {

	static int B, H;
	static boolean flag = false;
	
	static {
		
		Scanner sc = new Scanner(System.in);
		B = sc.nextInt();
		H = sc.nextInt();
		
		if(B < 0 || H < 0 ) {
			try {
				throw new Exception("Breadth and height must be positive");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if(B >= 0 && H > 0 ) {
			if(B < 100 && H < 100) {
				flag = true;
			}
		}
	}
	
	public static void main(String[] args) {
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
	}
	
}
