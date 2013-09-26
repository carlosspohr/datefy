package br.inf.carlos.datefy;

import java.util.Calendar;

public class TempDatefy {

	
	public static void main(String[] args) {
		
		Calendar start = Calendar.getInstance();
		start.set(2013, 0, 5);
		
		Calendar end = Calendar.getInstance();
		end.set(2014, 9, 5);
		
		System.out.println(Datefy.findDifferenceBetweenInDays(start, end));
		System.out.println(Datefy.findDifferenceBetweenInMonths(start, end));
		System.out.println(Datefy.findDifferenceBetweenInYears(start, end));
	}
}
