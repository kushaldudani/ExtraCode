package com.extracode;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Test4 {
	
	
	
	public static void main(String[] args) {
		/*TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 5, 30);
		//int diff = getDaysinpast(cal.getTime());
		System.out.println(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(cal.getTime());
		try {
			System.out.println(sdf.parse("2014-03-12"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//String xx = "3,399.00";
		//String yy = xx.replace(",", "");
		//System.out.println(yy);
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		Calendar cal = Calendar.getInstance();
		String hour = String.format("%02d",cal.get(Calendar.HOUR_OF_DAY));
		String minute = String.format("%02d",cal.get(Calendar.MINUTE));
		String lasttime = hour+":"+minute;
		System.out.println(lasttime);
		System.out.println(args.length);
		System.out.println("Enter something here : ");
		 
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
	 
		    System.out.println(s);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	private static int getDaysinpast(Date startdate) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(startdate);
		Calendar cal2 = Calendar.getInstance();
		long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();
        long diff = milis2 - milis1;
        long diffDays = diff / (24 * 60 * 60 * 1000);
		return (int) diffDays;
	}

}
