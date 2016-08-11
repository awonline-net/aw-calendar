package net.awonline.calendar.nonworkingday.day.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.day.AbstractNonWorkingDayTestSuite;

import org.junit.Before;
import org.junit.Test;

public class InternationalWorkersDayTest extends AbstractNonWorkingDayTestSuite {

	private InternationalWorkersDay internationalWorkersDay;

	@Before
	public void setUp() {
		internationalWorkersDay = new InternationalWorkersDay();
	}

	@Test
	public void isTheDayPositiveTest() {
		Day day = new Day(YEAR_2012, MAY, FIRST_DAY_OF_MONTH);

		boolean result = internationalWorkersDay.isTheDay(day);

		assertTrue("International Workers' Day should be on first may", result);
	}

	@Test
	public void isTheDayWrongMonthTest() {
		Day day = new Day(YEAR_2012, APRIL, FIRST_DAY_OF_MONTH);

		boolean result = internationalWorkersDay.isTheDay(day);

		assertFalse("International Workers' Day should be in may", result);
	}

	@Test
	public void isTheDayWrongDayOfMonthTest() {
		Day day = new Day(YEAR_2012, MAY, SECOND_DAY_OF_MONTH);

		boolean result = internationalWorkersDay.isTheDay(day);

		assertFalse("International Workers' Day should be on the first day of month", result);
	}

}
