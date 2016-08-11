package net.awonline.calendar.nonworkingday.exception;

public class YearOutOfRangeException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Year is out of range";

	public YearOutOfRangeException() {
		super(MESSAGE);
	}
}
