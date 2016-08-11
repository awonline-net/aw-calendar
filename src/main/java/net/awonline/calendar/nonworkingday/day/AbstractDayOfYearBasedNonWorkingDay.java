package net.awonline.calendar.nonworkingday.day;

import net.awonline.calendar.CalendarUtil;
import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.AbstractNonWorkingDay;

public abstract class AbstractDayOfYearBasedNonWorkingDay extends AbstractNonWorkingDay {

	private final int dayOfYear;

	public AbstractDayOfYearBasedNonWorkingDay(String name, int dayOfYear) {
		super(name);
		this.dayOfYear = dayOfYear;
	}

	@Override
	public boolean isTheDay(Day day) {
		return CalendarUtil.isDayOfYear(day, dayOfYear);
	}
}
