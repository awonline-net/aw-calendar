package net.awonline.calendar.nonworkingday.day.impl;

import java.util.Calendar;

import net.awonline.calendar.nonworkingday.day.AbstractDayOfMonthBasedNonWorkingDay;

public class InternationalWorkersDay extends AbstractDayOfMonthBasedNonWorkingDay {

	private static final String NAME = "International Workers' Day";

	private static final int MONTH_OF_YEAR = Calendar.MAY;
	private static final int DAY_OF_MONTH = 1;

	public InternationalWorkersDay() {
		super(NAME, MONTH_OF_YEAR, DAY_OF_MONTH);
	}
}
