package com.cts.dtd.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeDemoApp {

	public static void main(String[] args) {
		
		LocalTime start = LocalTime.now();
		
		LocalDateTime current = LocalDateTime.now();
		ZonedDateTime canadaTime = ZonedDateTime.now(ZoneId.of("UTC-5"));
		
		System.out.println(current);
		System.out.println(canadaTime);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-yyyy hh:mm:ss a");
		System.out.println(current.format(format));
		System.out.println(canadaTime.format(format));
		
		Scanner kb = new Scanner(System.in); 
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate today = LocalDate.now();
		System.out.println("DOB: ");
		String dobStr = kb.next();
		LocalDate dob = LocalDate.parse(dobStr,format2);
		
		Period p = Period.between(dob, today);
		System.out.println(p.toTotalMonths()/12.0);

		System.out.println(dob.plusYears(62).format(format2));
		
		LocalTime end = LocalTime.now();
		System.out.println(Duration.between(start, end).toMinutes());
	}

}
