package net.awonline.calendar.nonworkingday.day;

import net.awonline.calendar.CalendarUtil;
import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.AbstractNonWorkingDay;

public abstract class AbstractDayOfMonthBasedNonWorkingDay extends AbstractNonWorkingDay {

	private final int month;
	private final int dayOfMonth;

	public AbstractDayOfMonthBasedNonWorkingDay(String name, int month, int dayOfMonth) {
		super(name);
		this.month = month;
		this.dayOfMonth = dayOfMonth;
	}

	@Override
	public boolean isTheDay(Day day) {
		return CalendarUtil.isMonthOfYear(day, month) && CalendarUtil.isDayOfMonth(day, dayOfMonth);
	}
}
