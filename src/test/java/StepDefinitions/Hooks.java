package StepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import init.SetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Helper;

public class Hooks {
	SetUp setUp = new SetUp();
	Logger log = Logger.getLogger(Hooks.class);


	@Before
	public void start() {
		//setUp.launchAppiumServer();
		setUp.launchCalendarApp();
	}
	
	
	@After
	public void end(Scenario scenario) throws Throwable{
		
		SetUp.driver.closeApp();
		if(scenario.isFailed())
		{
			Helper.getScreenshots(scenario.getName());
			log.info("failed and took screenshot");
		}
		else
		{
		//log.info("passed");
		}
		//Tools.closeDriver();
		//service.stop();
		//log.info("Server successfully stopped");
		log.info("**************************************************************************");
	}
	public static void getScreenshots(String fileName) throws Throwable{
		
		File scrFile=((TakesScreenshot)SetUp.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\"+fileName+".png"));
	}
}
