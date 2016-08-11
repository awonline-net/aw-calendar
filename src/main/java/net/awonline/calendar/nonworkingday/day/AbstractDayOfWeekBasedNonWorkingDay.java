package net.awonline.calendar.nonworkingday.day;

import net.awonline.calendar.CalendarUtil;
import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.AbstractNonWorkingDay;

public abstract class AbstractDayOfWeekBasedNonWorkingDay extends AbstractNonWorkingDay {

	private final int dayOfWeek;

	public AbstractDayOfWeekBasedNonWorkingDay(String name, int dayOfWeek) {
		super(name);
		this.dayOfWeek = dayOfWeek;
	}

	@Override
	public boolean isTheDay(Day day) {
		return CalendarUtil.isDayOfWeek(day, dayOfWeek);
	}
}
