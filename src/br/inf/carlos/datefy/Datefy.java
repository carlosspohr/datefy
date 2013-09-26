package br.inf.carlos.datefy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;

public final class Datefy {
	
	public static final String MONTHS 	= "MONTHS";
	public static final String YEARS 	= "YEARS";
	public static final String DAYS 	= "DAYS";
	
	public static Integer findDifferenceBetweenInMonths(Calendar start, Calendar end){
		return findDifferenceBetween(start, end, MONTHS);
	}
	
	public static Integer findDifferenceBetweenInYears(Calendar start, Calendar end){
		return findDifferenceBetween(start, end, YEARS);
	}
	
	public static Integer findDifferenceBetweenInDays(Calendar start, Calendar end){
		return findDifferenceBetween(start, end, DAYS);
	}
	
	public static Integer findDifferenceBetween(Calendar start, Calendar end, String type){
		
		if(type == null || type.trim().isEmpty()){
			throw new IllegalArgumentException("You must inform a diff type (MONTHS, YEARS or DAYS).");
		}
		
		DateTime dtStart 	= new DateTime(start.getTimeInMillis());
		DateTime dtEnd 		= new DateTime(end.getTimeInMillis());
		
		if(MONTHS.equals(type)){
			return Months.monthsBetween(dtStart, dtEnd).getMonths();
		}
		else{
			if(YEARS.equals(type)){
				return Years.yearsBetween(dtStart, dtEnd).getYears();
			}
			else{
				return Days.daysBetween(dtStart, dtEnd).getDays();
			}
		}
	}

	public static String formatDDMMYYY(Calendar date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(date.getTime());
	}
	
	public static Calendar withFirstDay(Calendar date){
		Calendar ret = Calendar.getInstance();
		
		ret.setTime(date.getTime());
		ret.set(Calendar.DAY_OF_MONTH, 1);
		return ret;
	}
	
	public static Calendar withLastDay(Calendar date){
		Calendar ret = Calendar.getInstance();
		
		ret.setTime(date.getTime());
		ret.set(Calendar.DAY_OF_MONTH, date.getActualMaximum(Calendar.DAY_OF_MONTH));
		return ret;
	}
	
	public static Calendar withPreviousMonth(Calendar date){
		Calendar ret = Calendar.getInstance();
		
		ret.setTime(date.getTime());
		ret.set(Calendar.MONTH, date.get(Calendar.MONTH) -1);
		
		return ret;
	}
	
	public static Calendar withNextMonth(Calendar date){
		Calendar ret = Calendar.getInstance();
		
		ret.setTime(date.getTime());
		ret.set(Calendar.MONTH, date.get(Calendar.MONTH) +1);
		
		return ret;
	}

	public static Calendar withIncMonth(Calendar date, int months) {
		Calendar ret = Calendar.getInstance();
		
		ret.setTime(date.getTime());
		ret.set(Calendar.MONTH, date.get(Calendar.MONTH) + months);
		
		return ret;
	}

	public static Integer getCurrentYear() {
		Calendar ret = Calendar.getInstance();
		
		return ret.get(Calendar.YEAR);
	}

	public static Calendar withFirstMonthOfYear() {
		Calendar ret = Calendar.getInstance();
		ret.set(Calendar.MONTH, 0);
		
		return ret;
	}
	
	public static Calendar withFirstMonthOfYear(int year) {
		return withMonth(0, year);
	}

	public static Calendar withMonth(int month) {
		Calendar ret = Calendar.getInstance();
		ret.set(Calendar.MONTH, month);
		
		return ret;
	}
	
	public static Calendar withMonth(int month, int year) {
		Calendar ret = Calendar.getInstance();
		ret.set(Calendar.MONTH, month);
		ret.set(Calendar.YEAR, year);
		
		return ret;
	}
	
	public static Calendar withCurrentMonth() {
		return Calendar.getInstance();
	}
}
