package net.awonline.calendar.nonworkingday.day.easter;

import net.awonline.calendar.nonworkingday.day.easter.impl.CartersEasterCalculatingAlgorithm;

public class EasterCalculatingAlgorithmFactory {

	public static final CartersEasterCalculatingAlgorithm CARTERS_ALGORITHM = new CartersEasterCalculatingAlgorithm();

	public static final EasterCalculatingAlgorithm getDefaultAlgorithm() {
		return CARTERS_ALGORITHM;
	}
}
