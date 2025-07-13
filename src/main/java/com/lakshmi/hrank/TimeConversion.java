package com.lakshmi.hrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeConversion {
	
	// Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
	// Sample 07:05:45PM
	// Output 19:05:45

	public static void main(String[] args) {
		System.out.println(timeConversion("07:05:45PM"));
	}

	static String timeConversion(String s) {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssaa");
		
		try { 
			cal.setTime(sdf.parse(s));
			
		} catch(ParseException e) {
			
		}
		
		return new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
	}
}
