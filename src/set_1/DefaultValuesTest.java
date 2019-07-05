package set_1;

public class DefaultValuesTest {

	static int i;
	static int l;
	static boolean b;
	static double d;
	static char ch;
	static String s;
	
	int ii;
	int ll;
	boolean bb;
	double dd;
	char chch;
	String ss;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Should initialize local variables before use
		int iii;
		int lll;
		boolean bbb;
		double ddd;
		char chchch;
		
		DefaultValuesTest dvt = new DefaultValuesTest();
		
		System.out.println(i);
		System.out.println(l);
		System.out.println(b);
		System.out.println(d);
		System.out.println(ch);
		System.out.println(s);
		
		System.out.println();
		
		System.out.println(dvt.ii);
		System.out.println(dvt.ll);
		System.out.println(dvt.bb);
		System.out.println(dvt.dd);
		System.out.println(dvt.chch);
		System.out.println(dvt.ss);
		
		
//		System.out.println(iii);
//		System.out.println(lll);
//		System.out.println(bbb);
//		System.out.println(ddd);
//		System.out.println(chchch);
		
		
	}
	
}
