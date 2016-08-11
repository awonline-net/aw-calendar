package net.awonline.calendar;

import java.util.Calendar;

public class CalendarUtil {

	public static boolean isDayOfYear(Day day, int dayOfYear) {
		return dayOfYear == day.getCalendar().get(Calendar.DAY_OF_YEAR);
	}

	public static boolean isDayOfMonth(Day day, int dayOfMonth) {
		return dayOfMonth == day.getCalendar().get(Calendar.DAY_OF_MONTH);
	}

	public static boolean isDayOfWeek(Day day, int dayOfWeek) {
		return dayOfWeek == day.getCalendar().get(Calendar.DAY_OF_WEEK);
	}

	public static boolean isMonthOfYear(Day day, int monthOfYear) {
		return monthOfYear == day.getCalendar().get(Calendar.MONTH);
	}
}
