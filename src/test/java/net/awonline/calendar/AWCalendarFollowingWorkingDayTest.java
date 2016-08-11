package net.awonline.calendar;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import junit.framework.TestSuite;
import net.awonline.calendar.nonworkingday.day.impl.NewYearsDay;
import net.awonline.calendar.nonworkingday.day.impl.Saturday;

import org.junit.Before;
import org.junit.Test;

public class AWCalendarFollowingWorkingDayTest extends TestSuite {

	protected static final int YEAR_2011 = 2011;
	protected static final int YEAR_2012 = 2012;

	protected static final int JANUARY = Calendar.JANUARY;
	protected static final int DECEMBER = Calendar.DECEMBER;

	protected AWCalendar awCalendar;
	protected AWCalendar twoNonWorkingDaysCalendar;

	private static final Day WORKING_FRIDAY_2011_12_30 = new Day(YEAR_2011, DECEMBER, 30);
	private static final Day NON_WORKING_SATURDAY_2011_12_31 = new Day(YEAR_2011, DECEMBER, 31);

	@Before
	public void setUp() {
		awCalendar = new AWCalendar();
		awCalendar.addNonWorkingDay(new Saturday());

		twoNonWorkingDaysCalendar = new AWCalendar();
		twoNonWorkingDaysCalendar.addNonWorkingDay(new NewYearsDay());
		twoNonWorkingDaysCalendar.addNonWorkingDay(new Saturday());
	}

	@Test
	public void zeroDaysIntervalWhenCurrentDayIsWorkingDayTest() {
		int daysInterval = 0;

		Day result = awCalendar.getFollowingWorkingDay(WORKING_FRIDAY_2011_12_30, daysInterval);

		assertEquals("Following working day before day which is working day should be the same day",
				WORKING_FRIDAY_2011_12_30, result);
	}

	@Test
	public void zeroDaysIntervalWhenCurrentDayIsNonWorkingDaysTest() {
		int daysInterval = 0;

		Day result = twoNonWorkingDaysCalendar.getFollowingWorkingDay(NON_WORKING_SATURDAY_2011_12_31, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 2);
		assertEquals("Zero working days after day which isn't working day should be next working day", expectedResult,
				result);
	}

	@Test
	public void oneDayIntervalWhenCurrentDayIsNonWorkingDaysTest() {
		int daysInterval = 1;

		Day result = awCalendar.getFollowingWorkingDay(NON_WORKING_SATURDAY_2011_12_31, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 1);
		assertEquals("One working day after 31.12.2011 should be 01.01.2012", expectedResult, result);
	}

	@Test
	public void twoDaysIntervalWhenCurrentDayIsNonWorkingDaysTest() {
		int daysInterval = 2;

		Day result = awCalendar.getFollowingWorkingDay(NON_WORKING_SATURDAY_2011_12_31, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 2);
		assertEquals("Two working days after 31.12.2011 should be 02.01.2012", expectedResult, result);
	}

	@Test
	public void oneDayIntervalWhenFollowingDayIsNonWorkingDayTest() {
		int daysInterval = 1;

		Day result = awCalendar.getFollowingWorkingDay(WORKING_FRIDAY_2011_12_30, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 1);
		assertEquals("Next working day after 30.12.2011 should be 01.01.2012", expectedResult, result);
	}

	@Test
	public void twoDaysIntervalWhenFollowingDayIsNonWorkingDayTest() {
		int daysInterval = 2;

		Day result = awCalendar.getFollowingWorkingDay(WORKING_FRIDAY_2011_12_30, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 2);
		assertEquals("Two working days after 30.12.2011 should be 02.01.2012", expectedResult, result);
	}

	@Test
	public void oneDayIntervalWhenFollowingTwoDaysAreNonWorkingDaysTest() {
		int daysInterval = 1;

		Day result = twoNonWorkingDaysCalendar.getFollowingWorkingDay(WORKING_FRIDAY_2011_12_30, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 2);
		assertEquals("Next working day after 30.12.2011 should be 02.01.2012", expectedResult, result);
	}

	@Test
	public void twoDaysIntervalWhenFollowingTwoDaysAreNonWorkingDaysTest() {
		int daysInterval = 2;

		Day result = twoNonWorkingDaysCalendar.getFollowingWorkingDay(WORKING_FRIDAY_2011_12_30, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 3);
		assertEquals("Two working days after 30.12.2011 should be 03.01.2012", expectedResult, result);
	}

	@Test
	public void oneDayIntervalWhenCurrentAndFollowingDayIsNonWorkingDaysTest() {
		int daysInterval = 1;

		Day result = twoNonWorkingDaysCalendar.getFollowingWorkingDay(NON_WORKING_SATURDAY_2011_12_31, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 2);
		assertEquals("Next working day after 31.12.2011 should be 02.01.2012", expectedResult, result);
	}

	@Test
	public void twoDaysIntervalWhenCurrentAndFollowingDayIsNonWorkingDaysTest() {
		int daysInterval = 2;

		Day result = twoNonWorkingDaysCalendar.getFollowingWorkingDay(NON_WORKING_SATURDAY_2011_12_31, daysInterval);

		Day expectedResult = new Day(YEAR_2012, JANUARY, 3);
		assertEquals("Two working days after 31.12.2011 should be 03.01.2012", expectedResult, result);
	}
}