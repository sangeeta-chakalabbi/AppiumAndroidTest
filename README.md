## Project:
This framework tests, native calender App on an Android device.

## Description:
Automatically creates either recurring or single instance meetings on calander app

## Tools and Frameworks used

* Page Object Model
* BDD cucumber
* TestNG integration
* Cucumber Json reports
* log4j log

## Libraries Used:

* Appium
* Selenium WebDriver
* Java
* TestNG 
* Maven
* Cucumber
* log4j

##Automation Demo Video


![Demo Link](https://github.com/sangeeta-chakalabbi/AppiumAndroidTest/blob/main/mediaFiles/WorkShopMeeting.jpeg)

(https://github.com/sangeeta-chakalabbi/AppiumAndroidTest/blob/main/mediaFiles/AutomationDemo.mp4)


## Prerequisites Installations:

* JAVA 1.8 - Install Java and set the JAVA_HOME path on your machine.

* Node & NPM - Download & install node from https://nodejs.org/en/download/.

* Android*- Install Android Studio & set ANDROID_HOME path.
		Downloading the Android SDK
		Download the Android SDK tools such as
		Build tools
		Platform tools
		Android Emulator
		Intel HAXM installer etc.....
		Create an emulator device from AVD manager
* Logging
* Maven
* Cucumber -html -report
* Appium server must be started


## How This Framework Works:

This framework is built in Page Object Model style using TestNG framework.
We have cucumber "TestRunner" file which has links to test features and step definitions.
It can also pick only specified test tags for running.
* Test uses global properties specified in config.properties file
* Here are the minimal things you have to do:
* Create your tests
* Create your Page Object class w.r.t test that you have written, if not created already (Take the reference from src/main/java/PageObjectRepo.

##Sample Desired capabilities
![Desired Capabilities] (https://github.com/sangeeta-chakalabbi/AppiumAndroidTest/blob/main/mediaFiles/DesiredCapabilities.png)

##Test Run Summary
Tests are triggered from cucumber runner file

*To run the script from a command line in a Terminal window you can use the below command.*
```
mvn test verify -DdeviceName="Galaxy Note9" -Dcucumber.options="--tags @auto"
```

![](https://github.com/sangeeta-chakalabbi/AppiumAndroidTest/blob/main/mediaFiles/testSummary.png)

## Reporting and Logging
**Reporting Path**
```
./target/report/cucumber-html-reports/
```

![Report File Path](https://github.com/sangeeta-chakalabbi/AppiumAndroidTest/blob/main/mediaFiles/Cucumber%20Reports.png)
![Detailed Report](https://github.com/sangeeta-chakalabbi/AppiumAndroidTest/blob/main/mediaFiles/DetailedReport.png)

**Logging Path**
```
./src/test/java/Logs/ApplicationLog
```



## Assumptions

```
1.	Typical weekdays are from Monday to Friday AND they are specified in the full Name and not short form likes Mon 
2.	Sunday and Saturday is the only non working day
3.	The days on which the meeting has been scheduled will come up on logs
4.	The tear up and tear down information will also appear on logs
5.	Test deletes the meeting created by it
```

## Happy Path

```
1.A recurring meeting will be scheduled on a given weekday for a certain duration depending on the data provided in the feature file
```


## Error Prone Scenarios

```
1. 	SUNDAY AND SATURDAY NOT ACCEPTED
2. 	MEETING START DAY IS IN THE PAST
3. 	NOT 3 DAYS A WEEK MEETING

```

## Documentation and the Working Mobile Automation Execution video

*https://github.com/*


