package net.awonline.calendar.nonworkingday.exception;

public class NonWorkingDayNameNotInitializedException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Name shouldn't be null";

	public NonWorkingDayNameNotInitializedException() {
		super(MESSAGE);
	}
}
