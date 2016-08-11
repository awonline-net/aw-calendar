package net.awonline.calendar.nonworkingday.day.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.day.AbstractNonWorkingDayTestSuite;

import org.junit.Before;
import org.junit.Test;

public class SundayTest extends AbstractNonWorkingDayTestSuite {

	private static final int JANUARY_MONDAY_DAY = 2;
	private static final int JANUARY_SUNDAY_DAY = 1;

	private Sunday sunday;

	@Before
	public void setUp() {
		sunday = new Sunday();
	}

	@Test
	public void isTheDayPositiveTest() {
		Day day = new Day(YEAR_2012, JANUARY, JANUARY_SUNDAY_DAY);

		boolean result = sunday.isTheDay(day);

		assertTrue("Day should be sunday", result);
	}

	@Test
	public void isTheDayNegativeTest() {
		Day monday = new Day(YEAR_2012, JANUARY, JANUARY_MONDAY_DAY);

		boolean result = sunday.isTheDay(monday);

		assertFalse("Day shouldn't be sunday", result);
	}
}
