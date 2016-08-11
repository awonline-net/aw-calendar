package net.awonline.calendar.nonworkingday.day.impl;

import java.util.Calendar;

import net.awonline.calendar.nonworkingday.day.AbstractDayOfWeekBasedNonWorkingDay;


public class Sunday extends AbstractDayOfWeekBasedNonWorkingDay {

	private static final String NAME = "Sunday";
	private static final int DAY_OF_WEEK = Calendar.SUNDAY;

	public Sunday() {
		super(NAME, DAY_OF_WEEK);
	}
}
