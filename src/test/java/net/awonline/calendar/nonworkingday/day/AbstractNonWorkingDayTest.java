package net.awonline.calendar.nonworkingday.day;

import junit.framework.TestSuite;
import net.awonline.calendar.Day;
import net.awonline.calendar.nonworkingday.AbstractNonWorkingDay;
import net.awonline.calendar.nonworkingday.exception.NonWorkingDayNameNotInitializedException;

import org.junit.Test;

public class AbstractNonWorkingDayTest extends TestSuite {

	private class NullNameNonWorkingDay extends AbstractNonWorkingDay {

		public NullNameNonWorkingDay() {
			super(null);
		}

		@Override
		public boolean isTheDay(Day day) {
			return false;
		}
	}

	@Test(expected = NonWorkingDayNameNotInitializedException.class)
	public void nullNameNonWorkingDayConstructorTest() {
		new NullNameNonWorkingDay();
	}
}
