package net.awonline.calendar.nonworkingday.day.easter;

import static org.junit.Assert.assertNotNull;
import junit.framework.TestSuite;

import org.junit.Test;

public class EasterCalculatingAlgorithmFactoryTest extends TestSuite {

	@Test
	public void getDefaultAlgorithmTest() {
		EasterCalculatingAlgorithm defaultAlgorithm = EasterCalculatingAlgorithmFactory.getDefaultAlgorithm();
		assertNotNull("Default algorithm shouldn't be null", defaultAlgorithm);
	}
}
