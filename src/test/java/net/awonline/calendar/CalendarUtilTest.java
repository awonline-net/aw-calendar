package net.awonline.calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import junit.framework.TestSuite;

import org.junit.Test;

public class CalendarUtilTest extends TestSuite {

	private static final int YEAR = 2012;
	private static final int JANUARY = Calendar.JANUARY;
	private static final int FEBRUARY = Calendar.FEBRUARY;

	private static final int FIRST_DAY_OF_MONTH = 1;
	private static final int SECOND_DAY_OF_MONTH = 2;

	private static final int JANUARY_MONDAY = 2;
	private static final int JANUARY_TUESDAY = 3;

	@Test
	public void isDayOfYearPositiveTest() {
		Day day = new Day(YEAR, FEBRUARY, FIRST_DAY_OF_MONTH);

		boolean result = CalendarUtil.isDayOfYear(day, 32);

		assertTrue("First february should be 32 day of year", result);
	}

	@Test
	public void isDayOfYearNegativeTest() {
		Day day = new Day(YEAR, FEBRUARY, FIRST_DAY_OF_MONTH);

		boolean result = CalendarUtil.isDayOfYear(day, 33);

		assertFalse("First february shouldn't be 33 day of year", result);
	}

	@Test
	public void isDayOfMonthPositiveTest() {
		Day day = new Day(YEAR, FEBRUARY, FIRST_DAY_OF_MONTH);

		boolean result = CalendarUtil.isDayOfMonth(day, FIRST_DAY_OF_MONTH);

		assertTrue("First february should be first day of month", result);
	}

	@Test
	public void isDayOfMonthNegativeTest() {
		Day day = new Day(YEAR, FEBRUARY, SECOND_DAY_OF_MONTH);

		boolean result = CalendarUtil.isDayOfMonth(day, FIRST_DAY_OF_MONTH);

		assertFalse("Second february shouldn't be first day of month", result);
	}

	@Test
	public void isDayOfWeekPositiveTest() {
		int dayOfWeek = JANUARY_MONDAY;
		Day monday = new Day(YEAR, JANUARY, JANUARY_MONDAY);

		boolean result = CalendarUtil.isDayOfWeek(monday, dayOfWeek);

		assertTrue("Days day of week should be equal do dayOfWeek", result);
	}

	@Test
	public void isDayOfWeekNegativeTest() {
		int dayOfWeek = JANUARY_MONDAY;
		Day tuesday = new Day(YEAR, JANUARY, JANUARY_TUESDAY);

		boolean result = CalendarUtil.isDayOfWeek(tuesday, dayOfWeek);

		assertFalse("Days day of week should be equal do dayOfWeek", result);
	}

	@Test
	public void isMonthOfYearPositiveTest() {
		Day day = new Day(YEAR, FEBRUARY, SECOND_DAY_OF_MONTH);

		boolean result = CalendarUtil.isMonthOfYear(day, FEBRUARY);

		assertTrue("Years month should be february", result);
	}

	@Test
	public void isMonthOfYearNegativeTest() {
		Day day = new Day(YEAR, FEBRUARY, SECOND_DAY_OF_MONTH);

		boolean result = CalendarUtil.isMonthOfYear(day, JANUARY);

		assertFalse("Years month shouldn't be february", result);
	}
}
