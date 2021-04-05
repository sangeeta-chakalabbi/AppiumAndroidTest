package utils;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import PageObjectRepo.CreateMeetingPage;
import PageObjectRepo.LandingPage;
import init.SetUp;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Helper {

	Logger log = Logger.getLogger(Helper.class);
	org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(SetUp.driver,30);

	public boolean calendarAppHasLoaddedSuccessfully(LandingPage landingPage) {
		WebElement addMeetingButton = landingPage.getAddMeetingButton();
		return addMeetingButton.isDisplayed();
	}

	public MeetingDetails getScheduledMeetingDetails(MeetingDetails meetingInputs , LandingPage landingPage, CreateMeetingPage createMeeting) {
		

		return (getRecurringMeetingEventList(meetingInputs, landingPage, createMeeting));
		
	}
	
	public MeetingDetails getRecurringMeetingEventList(MeetingDetails meetingInputs , LandingPage landingPage,CreateMeetingPage createMeeting) {
		
		
		landingPage.getOpenDrawer().click();
		SetUp.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"Search\"));"));
		landingPage.getSearchButton().click();
		
		landingPage.getSearchText().sendKeys(meetingInputs.getTitle());
		SetUp.driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//SetUp.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.samsung.android.calendar:id/agenda_list\")).scrollIntoView(new UiSelector().textContains(\""+meetingInputs.getDay()+"\").instance(0))"));
		
		List<WebElement> matchingMeetings = landingPage.getMeetingOccurances();
		int totalWorkShopCount = matchingMeetings.size();
		
		MeetingDetails meetingOutput = new MeetingDetails();
		meetingOutput.setMeetingRepetitionCount(totalWorkShopCount);
		
		WebElement firstEventTitle = matchingMeetings.get(0).findElement(By.id("com.samsung.android.calendar:id/title"));
		meetingOutput.setTitle(firstEventTitle.getText());
		
		firstEventTitle.click();
		String repitetionText= landingPage.getRecurringTextInfo().getText();
		
		String[] substrings = repitetionText.split(" ");
		
		meetingOutput.setEndMonth(substrings[5]);
		
		int year = convertToInt(substrings[6]);
		int dayOfTheMonth = convertToInt(substrings[4]);
		Month[] months = Month.values();
		Month month = null;
		for(int i=0 ; i< months.length; i++) {
			months[i].getDisplayName(TextStyle.SHORT,Locale.ENGLISH).equals(substrings[5]);
			month = months[i];
		}		
		LocalDate endDate = LocalDate.of(year, month, dayOfTheMonth);
		meetingOutput.setEndDate(endDate);
		
		createMeeting.getNavigateUp().click();
		landingPage.getSearchBackButton().click();
		return meetingOutput;
	}
	
	public void bookAMeeting(MeetingDetails meetingInputs, LandingPage landingPage, CreateMeetingPage createMeeting ) {
		addMeeting(landingPage);
		setTitle(meetingInputs,createMeeting);
		setMeetingMonthAndDateAndTime(meetingInputs,landingPage,createMeeting);
		
		if (meetingInputs.getRecurringDurationInMonths() > 0 ) {
			setRecurringMeeting(meetingInputs,createMeeting);
		}
		saveTheMeeting(createMeeting);
		
	}
	
	public void addMeeting(LandingPage landingPage) {
		//click add meeting button
		WebElement addMeetingButton = landingPage.getAddMeetingButton();
		addMeetingButton.click();
	}
	
	public void setTitle(MeetingDetails meetingInputs, CreateMeetingPage createMeeting ) {
		createMeeting.setTitle(meetingInputs.getTitle());
	}
	
	public void setMeetingMonthAndDateAndTime(MeetingDetails meetingInputs, LandingPage landingPage, CreateMeetingPage createMeeting) {
		createMeeting.getStartDateTime().click();
		createMeeting.getDatePickerSpinner().click();
		setMonth(meetingInputs.getStartMonth(), createMeeting);
		setStartDateAndTIme(meetingInputs,createMeeting );
		
		updateMeetingInConfig(meetingInputs);

		//createMeeting.getEndDateTime().click();
		//createMeeting.getDatePickerSpinner().click();
		//setMonth(meetingInputs.getEndMonth(), createMeeting);
		setEndDateAndTime(meetingInputs,createMeeting);
	}
	
	public void updateMeetingInConfig(MeetingDetails meetingInputs) {
		int day = convertToInt(meetingInputs.getDayOfTheMonth());
		Month month = Month.valueOf(meetingInputs.getStartMonth().toUpperCase());
		int currentYear = LocalDate.now().getYear();
		
		LocalDate startDate = LocalDate.of(currentYear, month, day);
		meetingInputs.setBeginDate(startDate);
		
		LocalDate endDate  = startDate.plusMonths(meetingInputs.getRecurringDurationInMonths()) ;
		meetingInputs.setEndDate(endDate);
		
		String endMonthInCaps = endDate.getMonth().toString();
		Character firstCharInCaps = endMonthInCaps.charAt(0);
		String restOfTheStringInLowerCase = endMonthInCaps.substring(1, endMonthInCaps.length()).toLowerCase();
		String endOfMonthWithFirstLetterCaps = firstCharInCaps + restOfTheStringInLowerCase;
		
		log.info("End Month .... : "+ endOfMonthWithFirstLetterCaps);
		meetingInputs.setEndMonth(endOfMonthWithFirstLetterCaps);
		
		long totaloccurences = ChronoUnit.WEEKS.between(startDate, endDate);
		meetingInputs.setMeetingRepetitionCount(totaloccurences);
		

		log.info(meetingInputs.getMeetingRepetitionCount()+" of events will be created");

	}
	
	
	
	public void setMonth(String month, CreateMeetingPage createMeeting) {
		String monthYearText = createMeeting.getCalenderMonthText().getText();
		String inputMonth = month;
		int count = 0;
		while(count<=12) {
			count++;
			if(monthYearText.contains(inputMonth)) {
				String[] monthAndYear = monthYearText.split(" ");
			
				log.info("Storing the year value into meetingInputs: "+ convertToInt(monthAndYear[1]));
				
				return;
			}
			else {
				createMeeting.getNextMonthButton().click();	
				monthYearText = createMeeting.getCalenderMonthText().getText();
			}
		}
		
		
	}

	
	public void setRecurringMeeting(MeetingDetails meetingInputs, CreateMeetingPage createMeeting) {
		SetUp.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"Don't repeat\"));"));
		createMeeting.getRepeatButton().click();
		setRepeatFrequency(meetingInputs.getRecurringFrequency(), createMeeting);
		setRepeatUntil(meetingInputs, createMeeting);
		
		
	}
	
	public void setRepeatFrequency(String recurringFrequency, CreateMeetingPage createMeeting) {
		createMeeting.getEveryWeek().click();
		//createMeeting.getCustomizeButton().get(2).click();
	}
	
	public void setRepeatUntil(MeetingDetails meetingInputs, CreateMeetingPage createMeeting) {
		
		int months = meetingInputs.getRecurringDurationInMonths();
		createMeeting.getDuration().click();
		createMeeting.getUntil().click();
		
		setMonth(meetingInputs.getEndMonth(), createMeeting);
		//selectDate(meetingInputs.getDayOfTheMonth(), createMeeting); 
		
		createMeeting.getDoneButton().click();
		createMeeting.getNavigateUp().click();
	}
	
	public void selectDate(String dayOfTheMonth,CreateMeetingPage createMeeting ) {
		String tmpDayOfTheWeek = new String();
    	List<AndroidElement> dates= createMeeting.getDatePicker();
    	int size = dates.size();
    	
    	for(int i=0; i< size; i++) {
    		if(dates.get(i).getAttribute("focusable").equals("true")) {
    			tmpDayOfTheWeek = dates.get(i).getAttribute("contentDescription");
    			for(int j=i+1; j<size ; j++) {
    				tmpDayOfTheWeek = (dates.get(j).getAttribute("contentDescription"));
    				String[] subStrings = tmpDayOfTheWeek.split(" ");
    				if(subStrings[1].equals(dayOfTheMonth)) {  
    					wait.until(ExpectedConditions.visibilityOf(dates.get(j))) ;   					
    					//dates.get(j).click();
    				}
    			}
    		}
    	}
	}
	
	
	public void saveTheMeeting(CreateMeetingPage createMeeting) {
		createMeeting.getSaveButton().click();	}
	
	public void setStartDateAndTIme(MeetingDetails meetingInputs, CreateMeetingPage createMeeting ) {
		
		//createMeeting.getDatePickerSpinner().click();
		String dateSet = setDate(meetingInputs.getDay(), createMeeting); 
		String[] substrings = dateSet.split(" ");
		meetingInputs.setDayOfTheMonth(substrings[1]);
		
		
		setHour(meetingInputs.getStartHour() , createMeeting);
		setMinute(meetingInputs.getStartMinutes() , createMeeting);
		setAmPm(meetingInputs.getStartMeridiem(),createMeeting);		
	}
	public void setEndDateAndTime(MeetingDetails meetingInputs, CreateMeetingPage createMeeting ) {
		
		//createMeeting.getDatePickerSpinner().click();
		//setDate(meetingInputs.getDay(), createMeeting);
		
		setHour(meetingInputs.getEndHour(), createMeeting);
		setMinute(meetingInputs.getEndMinutes() , createMeeting);
		setAmPm(meetingInputs.getEndMeridiem(),createMeeting);		
	}
	
	public void setHour(String hour, CreateMeetingPage createMeeting) {
		createMeeting.setHourPickerSpinner(hour);
	}
	
	public void setMinute(String minute, CreateMeetingPage createMeeting) {
		createMeeting.setMinutePickerSpinner(minute);
	}
	
	public void setAmPm(String meridiem,CreateMeetingPage createMeeting ) {
		if(meridiem.equals("AM")) {
		createMeeting.setMeridiemToAm();
		}
		else if(meridiem.equals("PM")) {
			createMeeting.setMeridiemToPm();
		}
	}
	
	public String setDate(String weekOfTheDay , CreateMeetingPage createMeeting) {
		
		String tmpDayOfTheWeek = new String();
		boolean gotIt= false;
		 	 	
    	List<AndroidElement> dates= createMeeting.getDatePicker();
    	int size = dates.size();
    	
    	for(int i=0; i< size; i++) {
    		if(dates.get(i).getAttribute("checkable").equals("true")) {
    			tmpDayOfTheWeek = dates.get(i).getAttribute("contentDescription");
    			for(int j=i+1; j<size ; j++) {
    				tmpDayOfTheWeek = (dates.get(j).getAttribute("contentDescription"));
    				if(tmpDayOfTheWeek.contains(weekOfTheDay)) {  
    					dates.get(j).click();    					
    					gotIt=true;
    					return tmpDayOfTheWeek;
    					
    				}
    			}
    		}
    	}
    	return null;
	 
	}
	
	
	 public void waitForElementTobeAvailable() {
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	 }
	 
	 public void setStartDate(MeetingDetails meetingInputs,LandingPage landingPage, CreateMeetingPage createMeeting) {
		 
		 	String tmpDayOfTheWeek = new String();
		 
		 	createMeeting.getDatePickerSpinner().click();
		 	
	    	List<AndroidElement> dates= createMeeting.getDatePicker();
	    	int size = dates.size();
	    	
	    	for(int i=0; i< size; i++) {
	    		if(dates.get(i).getAttribute("checkable").equals("true")) {
	    			tmpDayOfTheWeek = dates.get(i).getAttribute("contentDescription");
	    			for(int j=i+1; j<size ; j++) {
	    				tmpDayOfTheWeek = (dates.get(j).getAttribute("contentDescription"));
	    			
	    				if(tmpDayOfTheWeek.contains(meetingInputs.getDay())) {
	    					dates.get(j).click();
	    				}
	    				
	    			}
	    		}
	    	}
	 }
	 
	 public int convertToInt(String value) {
		 return(Integer.parseInt(value));
	 }
	 
	 public void verifyScheduledMeetingDetails(MeetingDetails meetingInput , MeetingDetails meetingOutPut) {
	    	assertTrue(meetingInput.getTitle().equals(meetingOutPut.getTitle()));
			

	  }
	 
	 public void deleteTheMeeting(String meetingTitle, LandingPage landingPage, CreateMeetingPage createMeeting) {

			landingPage.getOpenDrawer().click();
			SetUp.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
	                ".scrollIntoView(new UiSelector().text(\"Search\"));"));
			landingPage.getSearchButton().click();
			
			landingPage.getSearchText().sendKeys(meetingTitle);
			SetUp.driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			
			List<WebElement> matchingMeetings = landingPage.getMeetingOccurances();
			
			
			WebElement firstEventTitle = matchingMeetings.get(0).findElement(By.id("com.samsung.android.calendar:id/title"));
			
			firstEventTitle.click();
			landingPage.getDeleteMeetingButton().click();
			landingPage.getDeleteAllEventsInTheSeriesButton().click();

	 }
	 
	 public boolean isValidDayOfTheWeekFOrmat(String weekDay) {
		 String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		 for(int i=0; i < days.length; i++) {
			 if (days[i].equals(weekDay)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 
	 public boolean isItAHoliday(String day) {
		 if(day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday")) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 
	 
	 public static void getScreenshots(String fileName) throws Throwable{
			
			File scrFile=((TakesScreenshot)SetUp.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./target/snapshots"+"/"+fileName+".png"));
			System.out.println("Snapshot finame   : "+ scrFile);
	}
		
	 
	 

}
