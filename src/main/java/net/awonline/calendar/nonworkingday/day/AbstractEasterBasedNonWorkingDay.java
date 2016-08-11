package net.awonline.calendar.nonworkingday.day;

import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.AbstractNonWorkingDay;
import net.awonline.calendar.nonworkingday.day.easter.EasterCalculatingAlgorithm;
import net.awonline.calendar.nonworkingday.day.easter.EasterCalculatingAlgorithmFactory;

public abstract class AbstractEasterBasedNonWorkingDay extends AbstractNonWorkingDay {

	private static final EasterCalculatingAlgorithm EASTER_CALCULATING_ALGORITHM = EasterCalculatingAlgorithmFactory
			.getDefaultAlgorithm();

	private final int daysAfterEasterSunday;

	public AbstractEasterBasedNonWorkingDay(String name, int daysAfterEasterSunday) {
		super(name);
		this.daysAfterEasterSunday = daysAfterEasterSunday;
	}

	@Override
	public boolean isTheDay(Day day) {
		int year = day.getYear();
		Day calculatedDay = EASTER_CALCULATING_ALGORITHM.getEasterSunday(year);
		calculatedDay.addDays(daysAfterEasterSunday);
		return day.equals(calculatedDay);
	}
}
