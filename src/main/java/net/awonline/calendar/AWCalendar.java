package net.awonline.calendar;

import java.util.HashSet;
import java.util.Set;

import net.awonline.calendar.nonworkingday.NonWorkingDay;

public class AWCalendar {

	private Set<NonWorkingDay> nonWorkingDays = new HashSet<NonWorkingDay>();

	public Set<NonWorkingDay> getNonWorkingDays() {
		return nonWorkingDays;
	}

	public void addNonWorkingDay(NonWorkingDay nonWorkingDay) {
		if (nonWorkingDay != null) {
			nonWorkingDays.add(nonWorkingDay);
		}
	}

	public void addNonWorkingDays(Set<NonWorkingDay> nonWorkingDays) {
		if (nonWorkingDays != null) {
			for (NonWorkingDay nonWorkingDay : nonWorkingDays) {
				addNonWorkingDay(nonWorkingDay);
			}
		}
	}

	public boolean isWorkingDay(Day day) {
		for (NonWorkingDay nonWorkingDay : nonWorkingDays) {
			if (nonWorkingDay.isTheDay(day)) {
				return false;
			}
		}
		return true;
	}

	public Day getFollowingWorkingDay(Day day, int daysInterval) {
		return calculateNextWorkingDay(day, daysInterval, true);
	}

	public Day getPreviousWorkingDay(Day day, int daysInterval) {
		return calculateNextWorkingDay(day, daysInterval, false);
	}

	private Day calculateNextWorkingDay(Day day, int daysInterval, boolean countForward) {
		Day resultDay = new Day(day);
		daysInterval = reduceDaysIntervalWhenFirstDayIsNonWorkingDay(resultDay, daysInterval);
		moveToNextWorkingDay(resultDay, daysInterval, countForward);
		return resultDay;
	}

	private int reduceDaysIntervalWhenFirstDayIsNonWorkingDay(Day day, int daysInterval) {
		if (!isWorkingDay(day)) {
			daysInterval--;
		}
		return daysInterval;
	}

	private void moveToNextWorkingDay(Day day, int daysInterval, boolean countForward) {
		int daysDelta = getDaysDelta(countForward);
		moveToNextWorkingDayByInterval(day, daysInterval, daysDelta);
		moveToNextWorkingDayUntilDayIsNotWorkingDay(day, daysDelta);
	}

	private int getDaysDelta(boolean countForward) {
		return countForward ? 1 : -1;
	}

	private void moveToNextWorkingDayByInterval(Day day, int daysInterval, int daysDelta) {
		while (daysInterval > 0) {
			if (isWorkingDay(day)) {
				daysInterval--;
			}
			day.addDays(daysDelta);
		}
	}

	private void moveToNextWorkingDayUntilDayIsNotWorkingDay(Day day, int daysDelta) {
		while (!isWorkingDay(day)) {
			day.addDays(daysDelta);
		}
	}
}
