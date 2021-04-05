package utils;

import java.time.LocalDate;

public class MeetingDetails {
	String title;
	String day;
	String dayOfTheMonth;
	String startMonth;
	String startHour;
	String startMinutes;
	String startMeridiem;
	LocalDate beginDate;
	
	String endMonth;
	String endHour;
	String endMinutes;
	String endMeridiem;
	LocalDate endDate;

	
	int recurringDurationInMonths;
	String recurringFrequency ;
	int year;
	long repetitionCount;
	int numberOfAttendies;
	boolean excludeHolidays;


	
	/**
	 * @return the endMonth
	 */
	public String getEndMonth() {
		return endMonth;
	}
	/**
	 * @param endMonth the endMonth to set
	 */
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	/**
	 * @return the meetingRepetitionCount
	 */
	public long getMeetingRepetitionCount() {
		return repetitionCount;
	}
	/**
	 * @param meetingRepetitionCount the meetingRepetitionCount to set
	 */
	public void setMeetingRepetitionCount(long meetingRepetitionCount) {
		this.repetitionCount = meetingRepetitionCount;
	}
	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the dayOfTheMonth
	 */
	public String getDayOfTheMonth() {
		return dayOfTheMonth;
	}
	/**
	 * @param dayOfTheMonth the dayOfTheMonth to set
	 */
	public void setDayOfTheMonth(String dayOfTheMonth) {
		this.dayOfTheMonth = dayOfTheMonth;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the startMonth
	 */
	public String getStartMonth() {
		return startMonth;
	}
	/**
	 * @param startMonth the startMonth to set
	 */
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}
	
	
	/**
	 * @return the beginDate
	 */
	public LocalDate getBeginDate() {
		return beginDate;
	}
	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * @return the recurringFrequency
	 */
	public String getRecurringFrequency() {
		return recurringFrequency;
	}
	/**
	 * @param recurringFrequency the recurringFrequency to set
	 */
	public void setRecurringFrequency(String recurringFrequency) {
		this.recurringFrequency = recurringFrequency;
	}
	/**
	 * @return the startMeridiem
	 */
	public String getStartMeridiem() {
		return startMeridiem;
	}
	/**
	 * @param startMeridiem the startMeridiem to set
	 */
	public void setStartMeridiem(String startMeridiem) {
		this.startMeridiem = startMeridiem;
	}
	/**
	 * @return the endMeridiem
	 */
	public String getEndMeridiem() {
		return endMeridiem;
	}
	/**
	 * @param endMeridiem the endMeridiem to set
	 */
	public void setEndMeridiem(String endMeridiem) {
		this.endMeridiem = endMeridiem;
	}


	
	/**
	 * @return the startHour
	 */
	public String getStartHour() {
		return startHour;
	}
	/**
	 * @param startHour the startHour to set
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	/**
	 * @return the startMinutes
	 */
	public String getStartMinutes() {
		return startMinutes;
	}
	/**
	 * @param startMinutes the startMinutes to set
	 */
	public void setStartMinutes(String startMinutes) {
		this.startMinutes = startMinutes;
	}
	/**
	 * @return the endHour
	 */
	public String getEndHour() {
		return endHour;
	}
	/**
	 * @param endHour the endHour to set
	 */
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	/**
	 * @return the endMinutes
	 */
	public String getEndMinutes() {
		return endMinutes;
	}
	/**
	 * @param endMinutes the endMinutes to set
	 */
	public void setEndMinutes(String endMinutes) {
		this.endMinutes = endMinutes;
	}

	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the numberOfAttendies
	 */
	public int getNumberOfAttendies() {
		return numberOfAttendies;
	}
	/**
	 * @param numberOfAttendies the numberOfAttendies to set
	 */
	public void setNumberOfAttendies(int numberOfAttendies) {
		this.numberOfAttendies = numberOfAttendies;
	}
	/**
	 * @return the excludeHolidays
	 */
	public boolean isExcludeHolidays() {
		return excludeHolidays;
	}
	/**
	 * @param excludeHolidays the excludeHolidays to set
	 */
	public void setExcludeHolidays(boolean excludeHolidays) {
		this.excludeHolidays = excludeHolidays;
	}
	/**
	 * @return the recurringDurationInMonths
	 */
	public int getRecurringDurationInMonths() {
		return recurringDurationInMonths;
	}
	/**
	 * @param recurringDurationInMonths the recurringDurationInMonths to set
	 */
	public void setRecurringDurationInMonths(int recurringDurationInMonths) {
		this.recurringDurationInMonths = recurringDurationInMonths;
	}

}
