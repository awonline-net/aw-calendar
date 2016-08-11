package net.awonline.calendar.nonworkingday.day.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.day.AbstractNonWorkingDayTestSuite;

import org.junit.Before;
import org.junit.Test;

public class SaturdayTest extends AbstractNonWorkingDayTestSuite {

	private static final int JANUARY_MONDAY = 2;
	private static final int JANUARY_SATURDAY = 7;

	private Saturday saturday;

	@Before
	public void setUp() {
		saturday = new Saturday();
	}

	@Test
	public void isTheDayPositiveTest() {
		Day day = new Day(YEAR_2012, JANUARY, JANUARY_SATURDAY);

		boolean result = saturday.isTheDay(day);

		assertTrue("Day should be saturday", result);
	}

	@Test
	public void isTheDayNegativeTest() {
		Day monday = new Day(YEAR_2012, JANUARY, JANUARY_MONDAY);

		boolean result = saturday.isTheDay(monday);

		assertFalse("Day shouldn't be saturday", result);
	}
}
