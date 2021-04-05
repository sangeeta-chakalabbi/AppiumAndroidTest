package PageObjectRepo;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import init.SetUp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage {
	

	org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(SetUp.driver,30);


	@AndroidFindBy(id="com.samsung.android.calendar:id/floating_action_button")
	private WebElement addMeetingButton;
	
	@AndroidFindBy(className="com.samsung.android.calendar:id/smallLabel")
	private List<AndroidElement> homePageDatePicker;
	
	
	@AndroidFindBy(className="android.view.View")
	private List<AndroidElement> LandingPageDays;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/open_drawer")
	private WebElement openDrawer;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search']")
	private WebElement searchButton;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	private List<WebElement> openDraw2;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	private WebElement searchText;
	
	@AndroidFindBy(className="android.widget.TextView")
	private List<WebElement> timeDateDetails;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/date")
	private List<WebElement> timeDateDetailsID;
	
	@AndroidFindBy(className="android.widget.RelativeLayout")
	private List<WebElement> meetingOccurances;

	@AndroidFindBy(id="com.samsung.android.calendar:id/repeat_text")
	private WebElement recurringTextInfo;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/detail_app_bar_menu_delete")
	private WebElement deleteMeetingButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/search_back_btn")
	private WebElement searchBackButton;


	/**
	 * @return the searchBackButton
	 */
	public WebElement getSearchBackButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(searchBackButton));

		return searchBackButton;
	}


	/**
	 * @param searchBackButton the searchBackButton to set
	 */
	public void setSearchBackButton(WebElement searchBackButton) {

		this.searchBackButton = searchBackButton;
	}


	/**
	 * @return the deleteMeetingButton
	 */
	public WebElement getDeleteMeetingButton() {
		return deleteMeetingButton;
	}


	/**
	 * @param deleteMeetingButton the deleteMeetingButton to set
	 */
	public void setDeleteMeetingButton(WebElement deleteMeetingButton) {
		this.deleteMeetingButton = deleteMeetingButton;
	}


	/**
	 * @return the deleteAllEventsInTheSeriesButton
	 */
	public WebElement getDeleteAllEventsInTheSeriesButton() {
		return deleteAllEventsInTheSeriesButton;
	}


	/**
	 * @param deleteAllEventsInTheSeriesButton the deleteAllEventsInTheSeriesButton to set
	 */
	public void setDeleteAllEventsInTheSeriesButton(WebElement deleteAllEventsInTheSeriesButton) {
		this.deleteAllEventsInTheSeriesButton = deleteAllEventsInTheSeriesButton;
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='All events in series']")
	private WebElement deleteAllEventsInTheSeriesButton;


	
	/**
	 * @return the recurringTextInfo
	 */
	public WebElement getRecurringTextInfo() {
		return recurringTextInfo;
	}


	/**
	 * @param recurringTextInfo the recurringTextInfo to set
	 */
	public void setRecurringTextInfo(WebElement recurringTextInfo) {
		this.recurringTextInfo = recurringTextInfo;
	}
	
	/**
	 * @return the meetingOccurances
	 */
	public List<WebElement> getMeetingOccurances() {
		return meetingOccurances;
	}

	/**
	 * @param meetingOccurances the meetingOccurances to set
	 */
	public void setMeetingOccurances(List<WebElement> meetingOccurances) {
		this.meetingOccurances = meetingOccurances;
	}

	/**
	 * @return the timeDateDetails
	 */
	public List<WebElement> getTimeDateDetails() {
		return timeDateDetails;
	}

	/**
	 * @param timeDateDetails the timeDateDetails to set
	 */
	public void setTimeDateDetails(List<WebElement> timeDateDetails) {
		this.timeDateDetails = timeDateDetails;
	}

	/**
	 * @return the searchText
	 */
	public WebElement getSearchText() {
		return searchText;
	}

	/**
	 * @param searchText the searchText to set
	 */
	public void setSearchText(WebElement searchText) {
		this.searchText = searchText;
	}

	/**
	 * @return the searchButton
	 */
	public WebElement getSearchButton() {
		return searchButton;
	}

	/**
	 * @param searchButton the searchButton to set
	 */
	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}

	/**
	 * @return the openDraw2
	 */
	public List<WebElement> getOpenDraw2() {
		return openDraw2;
	}

	/**
	 * @param openDraw2 the openDraw2 to set
	 */
	public void setOpenDraw2(List<WebElement> openDraw2) {
		this.openDraw2 = openDraw2;
	}

	/**
	 * @return the log
	 */
	public Logger getLog() {
		return log;
	}

	/**
	 * @return the openDrawer
	 */
	public WebElement getOpenDrawer() {
		return openDrawer;
	}

	/**
	 * @param openDrawer the openDrawer to set
	 */
	public void setOpenDrawer(WebElement openDrawer) {
		this.openDrawer = openDrawer;
	}

	/**
	 * @return the landingPageDays
	 */
	public List<AndroidElement> getLandingPageDays() {
		return LandingPageDays;
	}

	/**
	 * @param landingPageDays the landingPageDays to set
	 */
	public void setLandingPageDays(List<AndroidElement> landingPageDays) {
		LandingPageDays = landingPageDays;
	}

	/**
	 * @return the homePageDatePicker
	 */
	public List<AndroidElement> getHomePageDatePicker() {
		return homePageDatePicker;
	}

	/**
	 * @param homePageDatePicker the homePageDatePicker to set
	 */
	public void setHomePageDatePicker(List<AndroidElement> homePageDatePicker) {
		this.homePageDatePicker = homePageDatePicker;
	}

	Logger log = Logger.getLogger("LandingPage");

	
	public LandingPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public WebElement getAddMeetingButton() {
		return addMeetingButton;
	}

}
