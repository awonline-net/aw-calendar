package net.awonline.calendar.nonworkingday.day.easter.impl;

import java.util.Calendar;

import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.day.easter.AbstractEasterCalculatingAlgorithm;

public class CartersEasterCalculatingAlgorithm extends AbstractEasterCalculatingAlgorithm {

	private static final int LOWER_YEAR_RANGE = 1900;
	private static final int UPPER_YEAR_RANGE = 2099;

	public CartersEasterCalculatingAlgorithm() {
		super(LOWER_YEAR_RANGE, UPPER_YEAR_RANGE);
	}

	@Override
	protected Day calculateEasterSunday(int year) {

		int B = 225 - 11 * (year % 19);

		int D = ((B - 21) % 30) + 21;
		if (D > 48) {
			D--;
		}

		int E = (year + year / 4 + D + 1) % 7;

		int Q = D + 7 - E;

		return createDay(Q, year);
	}

	private Day createDay(int Q, int year) {

		int day = Q;
		int month = Calendar.MARCH;

		if (Q > 32) {
			day = Q - 31;
			month = Calendar.APRIL;
		}

		return new Day(year, month, day);
	}
}
