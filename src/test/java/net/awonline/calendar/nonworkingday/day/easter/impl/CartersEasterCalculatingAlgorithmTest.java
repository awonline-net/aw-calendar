package net.awonline.calendar.nonworkingday.day.easter.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.day.easter.EasterCalculatingAlgorithmTestSuite;
import net.awonline.calendar.nonworkingday.exception.YearOutOfRangeException;

import org.junit.Before;
import org.junit.Test;

public class CartersEasterCalculatingAlgorithmTest extends EasterCalculatingAlgorithmTestSuite {

	private static final int LOWER_RANGE_YEAR = 1900;
	private static final int UPPER_RANGE_YEAR = 2099;

	private CartersEasterCalculatingAlgorithm algorithm;

	@Before
	public void setUp() {
		algorithm = new CartersEasterCalculatingAlgorithm();
	}

	@Test
	public void defaultConstructorTest() {
		assertTrue("Lower range year should be initialized", LOWER_RANGE_YEAR == algorithm.getLowerRangeYear());
		assertTrue("Upper range year should be initialized", UPPER_RANGE_YEAR == algorithm.getUpperRangeYear());
	}

	@Test(expected = YearOutOfRangeException.class)
	public void getEasterSundayOutOfLowerRangeTest() {
		algorithm.getEasterSunday(LOWER_RANGE_YEAR - 1);
	}

	@Test(expected = YearOutOfRangeException.class)
	public void getEasterSundayOutOfUpperRangeTest() {
		algorithm.getEasterSunday(UPPER_RANGE_YEAR + 1);
	}

	@Test
	public void getEasterSundayIn2012PositiveTest() {
		Day result = algorithm.getEasterSunday(YEAR_2012);

		assertEquals("Easter Sunday in year " + YEAR_2012 + " should be on eight april", EASTER_SUNDAY_IN_2012, result);
	}

	@Test
	public void getEasterSundayIn2011PositiveTest() {
		/** Test for "D" subtracting **/
		Day result = algorithm.getEasterSunday(YEAR_2011);

		assertEquals("Easter Sunday in year " + YEAR_2011 + " should be on eight april", EASTER_SUNDAY_IN_2011, result);
	}

	@Test
	public void getEasterSundayNegativeTest() {
		Day day = new Day(YEAR_2012, Calendar.APRIL, 9);

		Day result = algorithm.getEasterSunday(YEAR_2012);

		assertFalse("Easter Sunday in year " + YEAR_2012 + " shouldn't be on ninth april", day.equals(result));
	}
}
