package com.test.automation.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.automation.utills.Halper;


public class TestBase {
	
	public static ExtentReports extentReports;
	public static ExtentTest logger;
	public WebDriver driver;
	String url="http://automationpractice.com/index.php";
	String browser="chrome";
	public static Logger log=Logger.getLogger(TestBase.class.getName());
	Halper objHalper=new Halper();

	@BeforeSuite
	public void setUpSuite(){
		
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		ExtentHtmlReporter objExtent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/src/main/java/ExecutionReport/test"+dateFormat.format(calendar.getTime())+".html"));
		extentReports=new ExtentReports();
		extentReports.attachReporter(objExtent);
	}
	
	public void init() {
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public void selectBrowser(String browser) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	public void getUrl(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		log.info("********* Chrome browser launch successfull************");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test  Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(objHalper.getScreenshot(driver)).build());
		} else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test  Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(objHalper.getScreenshot(driver)).build());
		}

		extentReports.flush();
	}
	
}
