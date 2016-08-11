package net.awonline.calendar.nonworkingday.day.impl;

import net.awonline.calendar.nonworkingday.day.AbstractEasterBasedNonWorkingDay;

public class EasterSunday extends AbstractEasterBasedNonWorkingDay {

	private static final String NAME = "Easter Sunday";
	private static final int DAYS_AFTER_EASTER_SUNDAY = 0;

	public EasterSunday() {
		super(NAME, DAYS_AFTER_EASTER_SUNDAY);
	}
}