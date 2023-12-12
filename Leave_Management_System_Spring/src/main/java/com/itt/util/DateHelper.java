package com.itt.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class DateHelper implements Serializable{
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public static Date readDate(String dateInString) throws ParseException
	{
		Date date = format.parse(dateInString);
		return date;
	}

	public static String returnDate(Date date)
	{
		String strDate = format.format(date);
		return strDate;
	}
	
	
	public static boolean checkOverlapConditions(Date firstStart,Date firstend,Date secondStart,Date secondEnd)
	{
		     
		     final String Colide = "Two Days collide";
		     
		     if((firstStart.after(secondStart) && firstend.before(secondEnd)) || secondStart.after(firstStart) && secondEnd.before(firstend))
		     {
		    	 System.out.println("clearly OverLap");
		    	 return false;
		     }
		     
		     else if(firstend.after(secondStart) && secondEnd.after(firstStart))
		     {
		    	 System.out.println("Partial Overlap");
		    	 return false;
		     }
		     
		     else if(firstend.equals(secondEnd) || firstStart.equals(secondStart))
		     {
		    	 return false;
		     }
		     else 
		     {
		    	 System.out.println("Doesnot colide");
		    	 return true;
		     }
	}
	
}

