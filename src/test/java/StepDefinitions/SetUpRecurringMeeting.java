package StepDefinitions;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.time.LocalDate;
import java.time.Month;

import org.apache.log4j.Logger;
import org.testng.Assert;

import PageObjectRepo.CreateMeetingPage;
import PageObjectRepo.LandingPage;
import init.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Helper;
import utils.MeetingDetails;

public class SetUpRecurringMeeting {
	SetUp setUp = new SetUp();
	LandingPage landingPage = new LandingPage(SetUp.driver);
	CreateMeetingPage createMeeting = new CreateMeetingPage(SetUp.driver);
	MeetingDetails meetingInputs = new MeetingDetails();
	MeetingDetails meetingOutputs = new MeetingDetails();

	Helper helper = new Helper();
	Logger log = Logger.getLogger(SetUpRecurringMeeting.class);

	
	String defaultDayOfTheWeek;
	String defaultDayOfTheMonth;
	String defaultMonth ;
	int defaultMonthNumber;
	
	@Given("I have launched the Calendar App")
	public void i_have_launched_the_calendar_app() {
		
		assertTrue(helper.calendarAppHasLoaddedSuccessfully(landingPage));
	}
		
	@When("Meeting is between {string} : {string} : {string} to {string} : {string} : {string}")
	public void meeting_is_between_to(String startHour, String startMinute, String startMeridiem, String endHour, String endMinute, String endMeridiem) {

		meetingInputs.setStartHour(startHour);
		meetingInputs.setStartMinutes(startMinute);
		meetingInputs.setStartMeridiem(startMeridiem);
		meetingInputs.setEndHour(endHour);
		meetingInputs.setEndMinutes(endMinute);
		meetingInputs.setEndMeridiem(endMeridiem);
	}
	
	@When("It occurs on every {string} : {string}")
	public void it_occurs_on_every_weekday(String frequency , String dayOfTheWeek) {
		assertTrue(helper.isValidDayOfTheWeekFOrmat(dayOfTheWeek));
		log.error("Test failed: Day of the week is invalid: Pick a valid day of the week");
		Assert.fail("Day of the week is invalid: Pick a valid day of the week");
		
		meetingInputs.setDay(dayOfTheWeek);
		meetingInputs.setRecurringFrequency(frequency);
	}

	@When("It is only on weekdays")
	public void it_is_only_on_weekdays() {
		meetingInputs.setExcludeHolidays(true);
	}
	
	@When("It starts from the month {string} and continues for next {string}")
	public void it_starts_from_the_month_and_continues_for_next(String startMonth, String numberOfMonths) {
		int monthCount = Integer.parseInt(numberOfMonths);
		if(monthCount <=0) {
			log.error("Test failed: Month count cannot be zero: Please chose a minimum of 1 month");
			Assert.fail("Month count cannot be zero: Please chose a minimum of 1 month");
		}
		meetingInputs.setStartMonth(startMonth);
		meetingInputs.setRecurringDurationInMonths(monthCount);
	}
	
	@When("I invite {string} of attendies")
	public void i_invite_of_attendies(String attendeeCount) {
		int numberOfAttendees = Integer.parseInt(attendeeCount);
		if(numberOfAttendees <=0) {
			log.error("Test failed: Attendees count cannot be zero: There has ti be atleast one attendee");
			Assert.fail("Attendees count cannot be zero: There has ti be atleast one attendee");
		}
		meetingInputs.setNumberOfAttendies(numberOfAttendees);
	}

	
	@Then("I want to book a meeting with the title {string}")
	public void i_want_to_book_a_meeting_with_the_title(String title) {
		meetingInputs.setTitle(title);
	}
	
	@Then("I save the meeting")
	public void i_save_the_meeting() {
		helper.bookAMeeting(meetingInputs,landingPage, createMeeting);
	}
	@Then("I Check if the meeting is created as expected")
	public void i_check_if_the_meeting_is_created_as_expected() {
		meetingOutputs = helper.getScheduledMeetingDetails(meetingInputs , landingPage, createMeeting);
		helper.verifyScheduledMeetingDetails(meetingInputs, meetingOutputs);
	}
	@Then("I can delete the meeting")
	public void i_can_delete_the_meeting() {
	    helper.deleteTheMeeting(meetingInputs.getTitle(), landingPage, createMeeting);
	}
}
