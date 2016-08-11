package net.awonline.calendar;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import junit.framework.TestSuite;
import net.awonline.calendar.nonworkingday.day.impl.NewYearsDay;
import net.awonline.calendar.nonworkingday.day.impl.Saturday;

import org.junit.Before;
import org.junit.Test;

public class AWCalendarPreviousWorkingDayTest extends TestSuite {

	protected static final int YEAR_2011 = 2011;
	protected static final int YEAR_2012 = 2012;

	protected static final int JANUARY = Calendar.JANUARY;
	protected static final int DECEMBER = Calendar.DECEMBER;

	protected AWCalendar awCalendar;
	protected AWCalendar twoNonWorkingDaysCalendar;

	private static final Day WORKING_MONDAY_2012_01_02 = new Day(YEAR_2012, JANUARY, 2);
	private static final Day NON_WORKING_SUNDAY_2012_01_01 = new Day(YEAR_2012, JANUARY, 1);

	@Before
	public void setUp() {
		awCalendar = new AWCalendar();
		awCalendar.addNonWorkingDay(new NewYearsDay());

		twoNonWorkingDaysCalendar = new AWCalendar();
		twoNonWorkingDaysCalendar.addNonWorkingDay(new NewYearsDay());
		twoNonWorkingDaysCalendar.addNonWorkingDay(new Saturday());
	}

	@Test
	public void zeroDaysIntervalWhenCurrentDayIsWorkingDayTest() {
		int daysInterval = 0;

		Day result = awCalendar.getPreviousWorkingDay(WORKING_MONDAY_2012_01_02, daysInterval);

		assertEquals("Previous working day before day which is working day should be the same day",
				WORKING_MONDAY_2012_01_02, result);
	}

	@Test
	public void zeroDaysIntervalWhenCurrentDayIsNonWorkingDaysTest() {
		int daysInterval = 0;

		Day result = twoNonWorkingDaysCalendar.getPreviousWorkingDay(NON_WORKING_SUNDAY_2012_01_01, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 30);
		assertEquals("Zero working days before day which isn't working day should be previous working day",
				expectedResult, result);
	}

	@Test
	public void oneDayIntervalWhenCurrentDayIsNonWorkingDaysTest() {
		int daysInterval = 1;

		Day result = awCalendar.getPreviousWorkingDay(NON_WORKING_SUNDAY_2012_01_01, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 31);
		assertEquals("One working day before 01.01.2012 should be 31.12.2011", expectedResult, result);
	}

	@Test
	public void twoDaysIntervalWhenCurrentDayIsNonWorkingDaysTest() {
		int daysInterval = 2;

		Day result = awCalendar.getPreviousWorkingDay(NON_WORKING_SUNDAY_2012_01_01, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 30);
		assertEquals("Two working days before 01.01.2012 should be 30.12.2011", expectedResult, result);
	}

	@Test
	public void oneDayIntervalWhenPreviousDayIsNonWorkingDayTest() {
		int daysInterval = 1;

		Day result = awCalendar.getPreviousWorkingDay(WORKING_MONDAY_2012_01_02, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 31);
		assertEquals("One working day before 02.01.2012 should be 31.12.2011", expectedResult, result);
	}

	@Test
	public void twoDaysIntervalWhenPreviousDayIsNonWorkingDayTest() {
		int daysInterval = 2;

		Day result = awCalendar.getPreviousWorkingDay(WORKING_MONDAY_2012_01_02, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 30);
		assertEquals("Two working days before 02.01.2012 should be 30.12.2011", expectedResult, result);
	}

	@Test
	public void oneDayIntervalWhenPreviousTwoDaysAreNonWorkingDaysTest() {
		int daysInterval = 1;

		Day result = twoNonWorkingDaysCalendar.getPreviousWorkingDay(WORKING_MONDAY_2012_01_02, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 30);
		assertEquals("One working day before 02.01.2012 should be 30.12.2011", expectedResult, result);
	}

	@Test
	public void twoDaysIntervalWhenPreviousTwoDaysAreNonWorkingDaysTest() {
		int daysInterval = 2;

		Day result = twoNonWorkingDaysCalendar.getPreviousWorkingDay(WORKING_MONDAY_2012_01_02, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 29);
		assertEquals("Two working days before 02.01.2012 should be 29.12.2011", expectedResult, result);
	}

	@Test
	public void oneDayIntervalWhenCurrentAndPreviousDayIsNonWorkingDaysTest() {
		int daysInterval = 1;

		Day result = twoNonWorkingDaysCalendar.getPreviousWorkingDay(NON_WORKING_SUNDAY_2012_01_01, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 30);
		assertEquals("One working day before 01.01.2012 should be 30.12.2011", expectedResult, result);
	}

	@Test
	public void twoDaysIntervalWhenCurrentAndPreviousDayIsNonWorkingDaysTest() {
		int daysInterval = 2;

		Day result = twoNonWorkingDaysCalendar.getPreviousWorkingDay(NON_WORKING_SUNDAY_2012_01_01, daysInterval);

		Day expectedResult = new Day(YEAR_2011, DECEMBER, 29);
		assertEquals("Two working days before 01.01.2012 should be 29.12.2011", expectedResult, result);
	}
}