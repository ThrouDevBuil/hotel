package br.com.guacom.hotel.util;

public class DateUtil {
	
	public static String getDateAndTime() {
		return java.time.Instant.now().toString();
	}
	
	public static String getDate() {
		return java.time.LocalDate.now().toString();
	}
}
