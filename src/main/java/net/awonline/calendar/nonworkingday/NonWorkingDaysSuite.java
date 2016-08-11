package net.awonline.calendar.nonworkingday;

import java.util.HashSet;
import java.util.Set;

public class NonWorkingDaysSuite {

	private Set<NonWorkingDay> nonWorkingDays = new HashSet<NonWorkingDay>();

	public void addNonWorkingDay(NonWorkingDay nonWorkingDay) {
		if (nonWorkingDay != null) {
			nonWorkingDays.add(nonWorkingDay);
		}
	}

	public Set<NonWorkingDay> getNonWorkingDays() {
		return nonWorkingDays;
	}

	public int getSuiteSize() {
		return nonWorkingDays.size();
	}
}
