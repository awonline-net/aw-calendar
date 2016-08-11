package net.awonline.calendar.nonworkingday.day.easter;

import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.exception.YearOutOfRangeException;

public abstract class AbstractEasterCalculatingAlgorithm implements EasterCalculatingAlgorithm {

	private int lowerRangeYear;
	private int upperRangeYear;

	public AbstractEasterCalculatingAlgorithm(int lowerRangeYear, int upperRangeYear) {
		this.lowerRangeYear = lowerRangeYear;
		this.upperRangeYear = upperRangeYear;
	}

	protected abstract Day calculateEasterSunday(int year);

	@Override
	public int getLowerRangeYear() {
		return lowerRangeYear;
	}

	@Override
	public int getUpperRangeYear() {
		return upperRangeYear;
	}

	@Override
	public Day getEasterSunday(int year) {
		if (isYearInRange(year)) {
			throw new YearOutOfRangeException();
		}

		return calculateEasterSunday(year);
	}

	private boolean isYearInRange(int year) {
		return year < lowerRangeYear || year > upperRangeYear;
	}
}
