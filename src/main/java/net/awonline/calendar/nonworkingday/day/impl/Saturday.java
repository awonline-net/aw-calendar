package net.awonline.calendar.nonworkingday.day.impl;

import java.util.Calendar;

import net.awonline.calendar.nonworkingday.day.AbstractDayOfWeekBasedNonWorkingDay;


public class Saturday extends AbstractDayOfWeekBasedNonWorkingDay {

	private static final String NAME = "Saturday";
	private static final int DAY_OF_WEEK = Calendar.SATURDAY;

	public Saturday() {
		super(NAME, DAY_OF_WEEK);
	}
}
