package net.awonline.calendar.nonworkingday.day.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import junit.framework.TestSuite;
import net.awonline.calendar.Day;

import org.junit.Before;
import org.junit.Test;

public class NewYearsDayTest extends TestSuite {

	private static final int YEAR = 2012;

	private static final int JANUARY = Calendar.JANUARY;
	private static final int FEBRUARY = Calendar.FEBRUARY;

	private static final int FIRST_MONTH_DAY = 1;
	private static final int SECOND_MONTH_DAY = 2;

	private NewYearsDay newYearsDay;

	@Before
	public void setUp() {
		newYearsDay = new NewYearsDay();
	}

	@Test
	public void isTheDayPositiveTest() {
		Day day = new Day(YEAR, JANUARY, FIRST_MONTH_DAY);

		boolean result = newYearsDay.isTheDay(day);

		assertTrue("Day should be New Years Day", result);
	}

	@Test
	public void isTheDayWrongMonthTest() {
		Day secondJanuary = new Day(YEAR, JANUARY, SECOND_MONTH_DAY);

		boolean result = newYearsDay.isTheDay(secondJanuary);

		assertFalse("New Year's Day is on first day of january", result);
	}

	@Test
	public void isTheDayWrongDayOfMonthTest() {
		Day firstFebruary = new Day(YEAR, FEBRUARY, FIRST_MONTH_DAY);

		boolean result = newYearsDay.isTheDay(firstFebruary);

		assertFalse("New Year's Day isn't in february", result);
	}
}
