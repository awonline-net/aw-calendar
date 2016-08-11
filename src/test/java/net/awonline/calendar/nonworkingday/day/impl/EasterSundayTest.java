package net.awonline.calendar.nonworkingday.day.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.day.AbstractNonWorkingDayTestSuite;

import org.junit.Before;
import org.junit.Test;

public class EasterSundayTest extends AbstractNonWorkingDayTestSuite {

	private EasterSunday easterSunday;

	@Before
	public void setUp() {
		easterSunday = new EasterSunday();
	}

	@Test
	public void isTheDayPositiveTest() {
		Day day = new Day(YEAR_2012, Calendar.APRIL, 8);

		boolean result = easterSunday.isTheDay(day);

		assertTrue("Easter Sunday in year " + YEAR_2012 + " should be on eight april", result);
	}

	@Test
	public void isTheDayNegativeTest() {
		Day day = new Day(YEAR_2012, Calendar.APRIL, 9);

		boolean result = easterSunday.isTheDay(day);

		assertFalse("Easter Sunday in year " + YEAR_2012 + " shouldn't be on ninth april", result);
	}
}
