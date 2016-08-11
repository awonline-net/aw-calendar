package net.awonline.calendar.nonworkingday;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import junit.framework.TestSuite;
import net.awonline.calendar.nonworkingday.day.impl.Sunday;

import org.junit.Before;
import org.junit.Test;

public class NonWorkingDaysSuiteTest extends TestSuite {

	private NonWorkingDaysSuite suite;

	@Before
	public void setUp() {
		suite = new NonWorkingDaysSuite();
	}

	@Test
	public void addNullNonWorkingDayTest() {
		suite.addNonWorkingDay(null);

		Set<NonWorkingDay> result = suite.getNonWorkingDays();

		assertTrue("Null shouldn't be added", result.isEmpty());
	}

	@Test
	public void addNonWorkingDayTest() {
		suite.addNonWorkingDay(new Sunday());

		Set<NonWorkingDay> result = suite.getNonWorkingDays();

		assertFalse("NoWorkingDay should be added", result.isEmpty());
	}

	@Test
	public void addTheSameNonWorkingDayMultipleTimeTest() {
		suite.addNonWorkingDay(new Sunday());
		suite.addNonWorkingDay(new Sunday());

		int suiteSize = suite.getSuiteSize();

		assertTrue("Adding the same NonWorkingDay to suite shouldn't be possible", 1 == suiteSize);
	}
}
