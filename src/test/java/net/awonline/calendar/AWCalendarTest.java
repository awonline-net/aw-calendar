package net.awonline.calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestSuite;
import net.awonline.calendar.nonworkingday.NonWorkingDay;
import net.awonline.calendar.nonworkingday.day.impl.NewYearsDay;
import net.awonline.calendar.nonworkingday.day.impl.Sunday;

import org.junit.Before;
import org.junit.Test;

public class AWCalendarTest extends TestSuite {

	private static final int YEAR_2012 = 2012;
	private static final int JANUARY = Calendar.JANUARY;

	private AWCalendar awCalendar;

	@Before
	public void setUp() {
		awCalendar = new AWCalendar();
	}

	@Test
	public void addNonWorkingDay() {
		awCalendar.addNonWorkingDay(new Sunday());

		Set<NonWorkingDay> result = awCalendar.getNonWorkingDays();

		assertFalse("NoWorkingDay should be added", result.isEmpty());
	}

	@Test
	public void addNonWorkingDayAddNull() {
		awCalendar.addNonWorkingDay(null);

		Set<NonWorkingDay> result = awCalendar.getNonWorkingDays();

		assertTrue("Null shouldn't be added", result.isEmpty());
	}

	@Test
	public void addNonWorkingDays() {
		Set<NonWorkingDay> nonWorkingDays = new HashSet<NonWorkingDay>();
		nonWorkingDays.add(new Sunday());
		nonWorkingDays.add(new NewYearsDay());

		awCalendar.addNonWorkingDays(nonWorkingDays);

		Set<NonWorkingDay> result = awCalendar.getNonWorkingDays();

		assertTrue("Two NonWorkingDay sholud be added", nonWorkingDays.size() == result.size());
	}

	@Test
	public void addNonWorkingDaysAddNull() {
		awCalendar.addNonWorkingDays(null);

		Set<NonWorkingDay> result = awCalendar.getNonWorkingDays();

		assertTrue("Null shouldn't be added", result.isEmpty());
	}

	@Test
	public void isWorkingDayWhenNonWorkingDaysArentPresent() {
		Day day = new Day();

		boolean result = awCalendar.isWorkingDay(day);

		assertTrue("All days sholuld be working days", result);
	}

	@Test
	public void isWorkingDayWhenNonWorkingDaysArePresent() {
		Day newYearsDay = new Day(YEAR_2012, JANUARY, 1);
		awCalendar.addNonWorkingDay(new NewYearsDay());

		boolean result = awCalendar.isWorkingDay(newYearsDay);

		assertFalse("New Year's is not working day", result);
	}
}
