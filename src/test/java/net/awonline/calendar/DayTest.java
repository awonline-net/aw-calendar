package net.awonline.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import junit.framework.TestSuite;

import org.junit.Test;

public class DayTest extends TestSuite {

	private static final int YEAR = 2012;
	private static final int MONTH = Calendar.JANUARY;
	private static final int DAY = 1;

	@Test
	public void defaultConstructorTest() {
		Day result = new Day();
		Calendar resultCalendar = result.getCalendar();

		Calendar now = Calendar.getInstance();

		assertEquals("Year field doesn't match", now.get(Calendar.YEAR), resultCalendar.get(Calendar.YEAR));
		assertEquals("Month field doesn't match", now.get(Calendar.MONTH), resultCalendar.get(Calendar.MONTH));
		assertEquals("Day field doesn't match", now.get(Calendar.DAY_OF_MONTH),
				resultCalendar.get(Calendar.DAY_OF_MONTH));
	}

	@Test
	public void cloneableConstructorTest() {
		Day day = new Day(YEAR, MONTH, DAY);

		Day dayClone = new Day(day);

		assertEquals("Cloned day should be equal", day, dayClone);
		assertTrue("Cloned day object shouldn't be equal", day != dayClone);
	}

	@Test
	public void parameterConstructorTest() {
		Day result = new Day(YEAR, MONTH, DAY);

		Calendar resultCalendar = result.getCalendar();

		assertEquals("Year field doesn't match", YEAR, resultCalendar.get(Calendar.YEAR));
		assertEquals("Month field doesn't match", MONTH, resultCalendar.get(Calendar.MONTH));
		assertEquals("Day field doesn't match", DAY, resultCalendar.get(Calendar.DAY_OF_MONTH));
	}

	@Test
	public void theSameObjectEqualityTest() {
		Day date = new Day(YEAR, MONTH, DAY);

		assertEquals("The same object should be equal", date, date);
		assertTrue("The same object should have the same hashcode", date.hashCode() == date.hashCode());
	}

	@Test
	public void differentObjectsEqualityTest() {
		Day dateOne = new Day(YEAR, MONTH, DAY);
		Day dateTwo = new Day(YEAR, MONTH, DAY);

		assertEquals("Objects should be equal", dateOne, dateTwo);
		assertTrue("Objects should have the same hashcode", dateOne.hashCode() == dateTwo.hashCode());
	}

	@Test
	public void objectsWithDifferentYearEqualityTest() {
		Day dateOne = new Day(YEAR, MONTH, DAY);
		Day dateTwo = new Day(YEAR + 1, MONTH, DAY);

		assertFalse("Objects with different year shouldn't be equal", dateOne.equals(dateTwo));
		assertFalse("Objects with different year shouldn't have the same hashcode",
				dateOne.hashCode() == dateTwo.hashCode());
	}

	@Test
	public void objectsWithDifferentMonthEqualityTest() {
		Day dateOne = new Day(YEAR, MONTH, DAY);
		Day dateTwo = new Day(YEAR, MONTH + 1, DAY);

		assertFalse("Objects with different month shouldn't be equal", dateOne.equals(dateTwo));
		assertFalse("Objects with different month shouldn't have the same hashcode",
				dateOne.hashCode() == dateTwo.hashCode());
	}

	@Test
	public void objectsWithDifferentDayEqualityTest() {
		Day dateOne = new Day(YEAR, MONTH, DAY);
		Day dateTwo = new Day(YEAR, MONTH, DAY + 1);

		assertFalse("Objects with different day shouldn't be equal", dateOne.equals(dateTwo));
		assertFalse("Objects with different day shouldn't have the same hashcode",
				dateOne.hashCode() == dateTwo.hashCode());
	}

	@Test
	public void differentObjectsTypeEqualityTest() {
		Day date = new Day();

		assertFalse("Different object types shouldn't be equal", date.equals(Long.valueOf(1)));
	}

	@Test
	public void nullObjectTypeEqualityTest() {
		Day date = new Day();

		assertFalse("Equals with null should return false", date.equals(null));
	}

	@Test
	public void addDaysTest() {
		int days = 2;
		Day day = new Day(YEAR, Calendar.DECEMBER, 31);

		Day expectedDay = new Day(YEAR + 1, Calendar.JANUARY, 2);

		day.addDays(days);

		assertEquals("Two days after thirty-first december should be second january", expectedDay, day);
	}

	@Test
	public void addDaysNegativeTest() {
		int days = -2;
		Day day = new Day(YEAR, Calendar.JANUARY, 1);

		Day expectedDay = new Day(YEAR - 1, Calendar.DECEMBER, 30);

		day.addDays(days);

		assertEquals("Two days before first january should be thirtieth december", expectedDay, day);
	}

	@Test
	public void addDaysZeroTest() {
		Day day = new Day(YEAR, Calendar.JANUARY, 1);

		day.addDays(0);

		assertEquals("Adding zero days shouldn't modify the day", day, day);
	}
}
