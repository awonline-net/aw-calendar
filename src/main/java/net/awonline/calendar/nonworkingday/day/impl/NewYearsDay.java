package net.awonline.calendar.nonworkingday.day.impl;

import net.awonline.calendar.nonworkingday.day.AbstractDayOfYearBasedNonWorkingDay;

public class NewYearsDay extends AbstractDayOfYearBasedNonWorkingDay {

	private static final String NAME = "New Year's Day";
	private static final int DAY_OF_YEAR = 1;

	public NewYearsDay() {
		super(NAME, DAY_OF_YEAR);
	}
}
