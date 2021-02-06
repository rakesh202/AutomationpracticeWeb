package com.test.automation.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.testBase.TestBase;
import com.test.automation.uiActions.AccountPage;

import com.test.automation.uiActions.Clothes;
import com.test.automation.uiActions.HomePage;
import com.test.automation.uiActions.OrderHistory;
import com.test.automation.uiActions.Payment;
import com.test.automation.uiActions.Profile;
import com.test.automation.uiActions.Women;

public class verifyEnetoEndFunctionality extends TestBase {
	HomePage homepage;
	Women objWomen;
	Clothes objClothes;
	Payment objPayment;
	Profile objProfile;
	OrderHistory objOrderHistory;
	AccountPage objAccountPage;

	
	public static Logger log=Logger.getLogger(verifyEnetoEndFunctionality.class.getName());
	@BeforeTest
	void setup() {
		
		init();
		log.info("***************Driver Initialization Completed************");
	}

	@Test
	void verifyEnetoEndFunctionality() throws InterruptedException {
		homepage = new HomePage(driver);
	
		objWomen = new Women(driver);
		objClothes = new Clothes(driver);
		objPayment = new Payment(driver);
		objProfile = new Profile(driver);
		objOrderHistory = new OrderHistory(driver);
		objAccountPage = new AccountPage(driver);

		logger = extentReports.createTest("Login to Automation Practice Account");

		log.info("*****************Login to Automation Practice Account ******");
		homepage.ap_LoginToApplication();
		logger.info("Successfully  Loging to Account .");
		logger.info("Goto T-Shirts Summer Dress Section .");
		objWomen.ap_TshirtstView();
		logger.info("First Item Faded Short Sleeve T-shirts Add to cart 5 Quantity .");
		logger.info("Click Proceed Checkout Button .   ");
		objClothes.ap_FirstItem();
		logger.info("First Item Successfully Added to cart  ");
		logger.info("Complete the Shopping Payment  .");
		objPayment.ap_Finalcheckout();
		logger.info(" Successfully Complete the Shopping Payment .");
		logger.info(" Goto User Profile Page and Click Order History Button .");
		objProfile.ap_CustomerOrderHistory();
		logger.info(" Successfully Clickd Order History Button .");
		objOrderHistory.ap_OrderHistory();
		logger.pass(" Order Details Successfully in Order Page  .");

	}
	
	

	@AfterTest
	void endTest() {
		objAccountPage.ap_SignOut();
		driver.close();
		log.info("*******closing browser******");
		
	}
}
