package net.awonline.calendar;

import java.util.Calendar;

public class Day {

	private int year;
	private int month;
	private int day;

	public Day() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		init(year, month, day);
	}

	public Day(Day day) {
		this(day.getYear(), day.getMonth(), day.getDay());
	}

	public Day(int year, int month, int day) {
		init(year, month, day);
	}

	public Calendar getCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar;
	}

	public void addDays(int days) {
		if (days != 0) {
			Calendar calendar = getCalendar();
			calendar.add(Calendar.DAY_OF_YEAR, days);

			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);

			init(year, month, day);
		}
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	private void init(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Day other = (Day) obj;
		if (year != other.year)
			return false;
		if (month != other.month)
			return false;
		if (day != other.day)
			return false;
		return true;
	}
}
