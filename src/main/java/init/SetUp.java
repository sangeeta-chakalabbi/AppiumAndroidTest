package init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SetUp {
	
	
	
	public static AndroidDriver<AndroidElement> driver = null;
	public static Properties prop = new Properties();
	protected static AppiumDriverLocalService service;
	


    static final Logger log = Logger.getLogger(SetUp.class);
    

	public void fetchConfigurations()  {
		
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("./src/main/java/config/config.properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
		}
		
		try {
			if(fs==null) {
				
			}
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
		}

		
	}
	
	public void launchCalendarApp()  {

		
		fetchConfigurations();
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty(MobileCapabilityType.PLATFORM_NAME));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty(MobileCapabilityType.PLATFORM_VERSION));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty(MobileCapabilityType.DEVICE_NAME));
		cap.setCapability(MobileCapabilityType.UDID, prop.getProperty(MobileCapabilityType.UDID));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty(MobileCapabilityType.AUTOMATION_NAME));
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty(AndroidMobileCapabilityType.APP_PACKAGE));
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,prop.getProperty(AndroidMobileCapabilityType.APP_ACTIVITY));
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, prop.getProperty(MobileCapabilityType.NEW_COMMAND_TIMEOUT));
		cap.setCapability(MobileCapabilityType.NO_RESET, true);		
//		System.out.println(prop.getProperty(MobileCapabilityType.PLATFORM_NAME));
//
//		System.out.println(prop.getProperty(MobileCapabilityType.PLATFORM_VERSION));
//	
//		System.out.println(prop.getProperty(MobileCapabilityType.DEVICE_NAME));
//
//		System.out.println(prop.getProperty(MobileCapabilityType.UDID));
//
//		System.out.println(prop.getProperty(MobileCapabilityType.AUTOMATION_NAME));
//		System.out.println(prop.getProperty(AndroidMobileCapabilityType.APP_PACKAGE));
//
//		System.out.println(prop.getProperty(AndroidMobileCapabilityType.APP_ACTIVITY));

		URL url =null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		driver = new AndroidDriver<AndroidElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	
	}

	public void launchAppiumServer() {
		
		fetchConfigurations();
		String nodeJSPath = prop.getProperty("nodeJSPath");
		String appiumPath = prop.getProperty("appiumPath");
		
		
		log.info("**************************************************************************");
		log.info("NODE = "+nodeJSPath);
		log.info("APPIUM = "+appiumPath);
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File(nodeJSPath));
		builder.withAppiumJS(new File(appiumPath));
		builder.usingAnyFreePort();
		service=AppiumDriverLocalService.buildService(builder);
		log.info("******URL + PORT *****"+service.getUrl());
		String x= service.getUrl().toString();
		log.info("STRING : "+x);
		String a[]=x.split(":");
		String b[]=a[2].split("/");
		log.info("URL  : "+b[0]);
		int portUsed=Integer.parseInt(b[0]);
		log.info("PORT USED  : "+portUsed);
		boolean serviceCheck=checkIfServerIsRunning(portUsed);
		if(!serviceCheck)
		{
				service.start();
		}
		log.info("Server successfully started");
	}
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		
		try
		{
			serverSocket = new ServerSocket(port);
			serverSocket.close();
			
		}
		catch(IOException e)
		{
			isServerRunning = true;
		}
		finally
		{
			serverSocket = null;
		}
		
		return isServerRunning;
	}
	
}
