package net.awonline.calendar.nonworkingday.day;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.TestSuite;

import net.awonline.calendar.nonworkingday.day.impl.Saturday;
import net.awonline.calendar.nonworkingday.day.impl.Sunday;

import org.junit.Test;

public class NonWorkingDayEqualityTest extends TestSuite {

	@Test
	public void theSameObjectEqualityTest() {
		Sunday sunday = new Sunday();

		assertEquals("The same object should be equal", sunday, sunday);
		assertTrue("The same object should have the same hashcode", sunday.hashCode() == sunday.hashCode());
	}

	@Test
	public void differentObjectsEqualityTest() {
		Sunday sunday1 = new Sunday();
		Sunday sunday2 = new Sunday();

		assertEquals("Objects should be equal", sunday1, sunday2);
		assertTrue("Objects should have the same hashcode", sunday1.hashCode() == sunday2.hashCode());
	}

	@Test
	public void differentObjectsTypeEqualityTest() {
		Sunday sunday = new Sunday();
		Saturday saturday = new Saturday();

		assertFalse("Different object types shouldn't be equal", sunday.equals(saturday));
	}

	@Test
	public void nullObjectTypeEqualityTest() {
		Sunday sunday = new Sunday();

		assertFalse("Equals with null should return false", sunday.equals(null));
	}
}
