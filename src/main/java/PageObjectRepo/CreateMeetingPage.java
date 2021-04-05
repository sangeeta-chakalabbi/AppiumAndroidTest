package PageObjectRepo;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import init.SetUp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CreateMeetingPage {

	org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(SetUp.driver,30);
	Logger log = Logger.getLogger(CreateMeetingPage.class);

	
	@AndroidFindBy(id="com.samsung.android.calendar:id/title")
	private WebElement meetingTitle;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/start_date_time")
	private WebElement startDateTime;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/end_date_time")
	private WebElement endDateTime;
	
	@AndroidFindBy(uiAutomator="textContains(\"Double tap to switch to calendar view.\")")
	private WebElement datePickerSpinner;
	
	@AndroidFindBy(uiAutomator="textContains(\"Hour,\")") 
	private WebElement hourPickerSpinnerButton;

	@AndroidFindBy(uiAutomator="textContains(\"Minute,\")") 
	private WebElement minutePickerSpinnerButton;
	
	@AndroidFindBy(uiAutomator="textContains(\"m,\")") 
	private List<WebElement> amPmPickerSpinnerButtons;
	
	@AndroidFindBy(className="android.widget.EditText")
	private List<AndroidElement> timeComponents;
	
	@AndroidFindBy(className="android.view.View")
	private List<AndroidElement> datePicker;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/repeat_text")
	private WebElement repeatButton;
	
	@AndroidFindBy(className="android.widget.RadioButton")
	private List<WebElement> customizeButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='week, , ']")
	private WebElement weekText;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Every week']")
	private WebElement everyWeek;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/repeat_duration_container")
	private WebElement duration;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/repeat_duration_option_end_date_container")
	private WebElement until;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/sesl_date_picker_calendar_header_next_button")
	private WebElement nextMonthButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/button1")
	private WebElement doneButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private WebElement navigateUp;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/smallLabel")
	private WebElement saveButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/sesl_date_picker_calendar_header_text")
	private WebElement calenderMonthText;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/sesl_timepicker_layout")
	private WebElement timePicker;
	

	public WebElement getHourPickerSpinnerButtons() {
		return hourPickerSpinnerButton;
	}


	public void setHourPickerSpinnerButtons(WebElement hourPickerSpinnerButton) {
		this.hourPickerSpinnerButton = hourPickerSpinnerButton;
	}


	public WebElement getMinutePickerSpinnerButton() {
		return minutePickerSpinnerButton;
	}


	public void setMinutePickerSpinnerButton(WebElement minutePickerSpinnerButton) {
		this.minutePickerSpinnerButton = minutePickerSpinnerButton;
	}


	public List<WebElement> getAmPmPickerSpinnerButtons() {
		return amPmPickerSpinnerButtons;
	}


	public void setAmPmPickerSpinnerButtons(List<WebElement> amPmPickerSpinnerButtons) {
		this.amPmPickerSpinnerButtons = amPmPickerSpinnerButtons;
	}

	/**
	 * @return the calenderMonthText
	 */
	public WebElement getCalenderMonthText() {
		return calenderMonthText;
	}


	/**
	 * @param calenderMonthText the calenderMonthText to set
	 */
	public void setCalenderMonthText(WebElement calenderMonthText) {
		this.calenderMonthText = calenderMonthText;
	}


	/**
	 * @return the navigateUp
	 */
	public WebElement getNavigateUp() {
		//return (navigateUpToolBar.findElement(By.className("android.widget.ImageButton")));
		wait.until(ExpectedConditions.elementToBeClickable(navigateUp));
		return navigateUp;
	}


	
	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}


	/**
	 * @param saveButton the saveButton to set
	 */
	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}
	
	
	/**
	 * @return the doneButton
	 */
	public WebElement getDoneButton() {
		return doneButton;
	}


	/**
	 * @param doneButton the doneButton to set
	 */
	public void setDoneButton(WebElement doneButton) {
		this.doneButton = doneButton;
	}


	/**
	 * @return the nextMonthButton
	 */
	public WebElement getNextMonthButton() {
		return nextMonthButton;
	}


	/**
	 * @param nextMonthButton the nextMonthButton to set
	 */
	public void setNextMonthButton(WebElement nextMonthButton) {
		this.nextMonthButton = nextMonthButton;
	}


	/**
	 * @return the until
	 */
	public WebElement getUntil() {
		return until;
	}


	/**
	 * @param until the until to set
	 */
	public void setUntil(WebElement until) {
		this.until = until;
	}


	/**
	 * @return the duration
	 */
	public WebElement getDuration() {
		return duration;
	}


	/**
	 * @param duration the duration to set
	 */
	public void setDuration(WebElement duration) {
		this.duration = duration;
	}


	/**
	 * @return the everyWeek
	 */
	public WebElement getEveryWeek() {
		return everyWeek;
	}


	/**
	 * @param everyWeek the everyWeek to set
	 */
	public void setEveryWeek(WebElement everyWeek) {
		this.everyWeek = everyWeek;
	}


	/**
	 * @return the weekText
	 */
	public WebElement getWeekText() {
		return weekText;
	}


	/**
	 * @param weekText the weekText to set
	 */
	public void setWeekText(WebElement weekText) {
		this.weekText = weekText;
	}


	/**
	 * @return the customizeButton
	 */
	public List<WebElement> getCustomizeButton() {
		return customizeButton;
	}


	/**
	 * @param customizeButton the customizeButton to set
	 */
	public void setCustomizeButton(List<WebElement> customizeButton) {
		this.customizeButton = customizeButton;
	}


	/**
	 * @return the repeatButton
	 */
	public WebElement getRepeatButton() {
		return repeatButton;
	}


	/**
	 * @param repeatButton the repeatButton to set
	 */
	public void setRepeatButton(WebElement repeatButton) {
		this.repeatButton = repeatButton;
	}


	/**
	 * @return the datePickerSpinner
	 */
	public WebElement getDatePickerSpinner() {
		wait.until(ExpectedConditions.elementToBeClickable(datePickerSpinner));
		return datePickerSpinner;
	}


	/**
	 * @param datePickerSpinner the datePickerSpinner to set
	 */
	public void setDatePickerSpinner(String text ) {
		;
	}



	
	public CreateMeetingPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public WebElement getStartDateTime() {
		
		wait.until(ExpectedConditions.elementToBeClickable(startDateTime));
		return startDateTime;
		
	}
	
    public WebElement getEndDateTime() {
		
		wait.until(ExpectedConditions.elementToBeClickable(endDateTime));

		return endDateTime;
		
	}
	public AndroidElement getAmMeridiem() {
	
		timeComponents = SetUp.driver.findElements(By.className("android.widget.EditText"));
		System.out.println(returnElementWith("AM", timeComponents).getText());
		return (returnElementWith("AM", timeComponents));
	
	}
	
	public AndroidElement getPmMeridiem() {
		
		timeComponents = SetUp.driver.findElements(By.className("android.widget.EditText"));
		System.out.println(returnElementWith("PM", timeComponents).getText());
		return (returnElementWith("PM", timeComponents));
	
	}


	public WebElement getMinutePickerSpinner() {
		timeComponents = SetUp.driver.findElements(By.className("android.widget.EditText"));
		return (returnElementWith("Minute", timeComponents));	
	}
	
	public WebElement getHourPickerSpinner() {
		timeComponents = SetUp.driver.findElements(By.className("android.widget.EditText"));
		return (returnElementWith("Hour", timeComponents));	
	}
	
	public WebElement getTitle() {
		timeComponents = SetUp.driver.findElements(By.className("android.widget.EditText"));
		return (returnElementWith("Title", timeComponents));	
	}
	
	 public void setHourPickerSpinner(String hour) {
			
	    	WebElement hourElement = getHourPickerSpinner();
	    	wait.until(ExpectedConditions.elementToBeClickable(hourElement));
	    	//hourElement.click();
	    	//waitForElementTobeAvailable();
	    	log.info(hourElement.getText());  
	    	
	    	//hourElement.sendKeys(hour+", Hour");		
	}
	 
	 public void setMinutePickerSpinner(String minute) {
			
	    	WebElement minuteElement = getHourPickerSpinner();
	    	wait.until(ExpectedConditions.elementToBeClickable(minuteElement));
	    	//hourElement.click();
	    	//waitForElementTobeAvailable();
	    	log.info(minuteElement.getText());  
	    	
	    	//hourElement.sendKeys(hour+", Hour");		
	}
	    
	 public void setMeridiemToPm() {
			
//	    	WebElement amElement = getAmMeridiem();
//	    	wait.until(ExpectedConditions.elementToBeClickable(amElement));
//	    	amElement.click();
//	    	waitForElementTobeAvailable();
//	    	log.info(amElement.getText());  
//	    	
//	    	amElement.sendKeys("PM");		
		}
	 
	 public void setMeridiemToAm() {
			
//	    	WebElement pmElement = getPmMeridiem();
//	    	wait.until(ExpectedConditions.elementToBeClickable(pmElement));
//	    	pmElement.click();
//	    	waitForElementTobeAvailable();
//	    	log.info(pmElement.getText());  
//	    	
//	    	pmElement.sendKeys("AM");		
		}
	 
	 public void setTitle(String title) {
			
	    	WebElement titleElement = getTitle();
	    	//titleElement.click();
	    	titleElement.sendKeys(title);
		}
	    

    
   
    public List<AndroidElement> getDatePicker() {
    	datePicker = SetUp.driver.findElements(By.className("android.view.View"));
    	waitForElementTobeAvailable();
		return datePicker;
	}

    
    
    public void waitForElementTobeAvailable() {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public AndroidElement returnElementWith(String text, List<AndroidElement> elements) {
		AndroidElement element = null;
    	for(int i=0; i< elements.size(); i++) {
			if(elements.get(i).getText().contains(text) ) {
				element = elements.get(i);
				break;
			}

		}
    	System.out.println(element.getText());
		return element;
    }

    
}
