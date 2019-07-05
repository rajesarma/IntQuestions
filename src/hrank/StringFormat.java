package hrank;

import java.text.DecimalFormat;

public class StringFormat {

	private int hour=9;
	private int minute=10;
	private int second=15;
	
	 public String railwayTime(){
	        return String.format("%02d:%02d:%02d",hour,minute,second);//error in this line
	    }
	
	public static void main(String[] args) {
		
		String[] str = {"Java","cpp", "python"};
		int[] num = {100, 65, 50};
		
		double[] dou = {100.46, 65.3467, 50.1};
		
		//System.out.println(String.format("value is %12.0012f",0.33434));
		
		
//		System.out.println(String.format(a+"%15.3s", i));
//		String abc = a+String.format("%15s", "")+String.format("%03d", i);
//		System.out.println(abc);
		//System.out.println(a+String.format("%15s", "")+String.format("%03d", i));
		
		for(int i=0; i< str.length; i++) {
			
			//System.out.println(str[i]+String.format("%-15s", "")+String.format("%03d", num[i]));
			/*System.out.print(str[i]+String.format("%-15s", ""));
			System.out.println(String.format("%03d", num[i]));*/
			
			System.out.println(String.format("%-15s",str[i])+String.format("%03d", num[i])+String.format("%15s","")+ new DecimalFormat("000.00").format(dou[i]));
			
			//System.out.println(new DecimalFormat("000.00").format(dou[i]));
			
		}
		
		//System.out.println(String.format("%02d:%02d:%02d", hour, minute, second) );
		StringFormat sf = new StringFormat();
		System.out.println(sf.railwayTime() );
		
	}
}
