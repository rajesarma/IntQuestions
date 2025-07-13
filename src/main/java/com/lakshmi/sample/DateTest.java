package com.lakshmi.sample;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {

	public static void main(String[] args) {
		Date date= new Date(2019, 04, 06);
		SimpleDateFormat sd = new SimpleDateFormat("EEEE" , java.util.Locale.ENGLISH);
		System.out.println(sd.format(date));
		
		Calendar cal = Calendar.getInstance();
		cal.set(2019, 03, 06);
		
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));

		
		SimpleDateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		try {
			
			
			java.util.Date dt = df.parse(03+"/"+(04-1)+"/"+2019);
			
			df.applyPattern("EEEE");
			
			System.out.println(df.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
//		dt.fo
		
		/*switch(Day) {
			case 0 : 
				day ="SUNDAY";
				break;
			case 1 : 
				day ="MONDAY";
				break;
			case 2 : 
				day ="TUESDAY";
				break;
			case 3 : 
				day ="WEDNESDAY";
				break;
			case 4 : 
				day ="THURSDAY";
				break;
			case 5 : 
				day ="FRIDAY";
				break;
			case 6 : 
				day ="SATURDAY";
				break;	
		}*/
		
//		System.out.println(day);
	}
	
}
