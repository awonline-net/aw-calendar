package net.awonline.calendar.nonworkingday.day.easter;

import net.awonline.calendar.Day;

public interface EasterCalculatingAlgorithm {

	int getLowerRangeYear();

	int getUpperRangeYear();

	Day getEasterSunday(int year);
}
