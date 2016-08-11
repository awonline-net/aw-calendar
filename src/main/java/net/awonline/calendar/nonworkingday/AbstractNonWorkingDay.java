package net.awonline.calendar.nonworkingday;

import net.awonline.calendar.nonworkingday.exception.NonWorkingDayNameNotInitializedException;

public abstract class AbstractNonWorkingDay implements NonWorkingDay {

	private final String name;

	public AbstractNonWorkingDay(String name) {
		if (name == null) {
			throw new NonWorkingDayNameNotInitializedException();
		}
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}
}
