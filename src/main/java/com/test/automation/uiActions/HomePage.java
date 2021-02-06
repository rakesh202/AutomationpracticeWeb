package com.test.automation.uiActions;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.testBase.TestBase;

public class HomePage {

	WebDriver driver;
	public static Logger log=Logger.getLogger(HomePage.class.getName());
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signIn;

	@FindBy(xpath = "//input[@id='email']")
	WebElement loginEmailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement loginPassword;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement submitButton;

	@FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
	WebElement authonticationFailed;
	//*****
	
	@FindBy(id = "customer_firstname")
	WebElement firstName;
	
	@FindBy(id = "customer_lastname")
	WebElement lastName;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "passwd")
	WebElement createPassword;
	
	@FindBy(id = "days")
	WebElement birthDays;
	
	@FindBy(id="id_gender1")
	WebElement gender;
	
	
	
	/*******************************************************************************
	 * @Function Name : ap_LoginToApplication
	 * @Description : Login to Application 
	 * @Author Name : Rakesh
	 ********************************************************************************/


	public void ap_LoginToApplication() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		try {

			if (signIn.isDisplayed())
				signIn.click();

			log.info("**************************Login to Account************************** ");
			wait.until(ExpectedConditions.visibilityOf(loginEmailAddress));
			loginEmailAddress.sendKeys("jetblue@grr.la");
			loginPassword.sendKeys("jetblue");
			submitButton.click();
			log.info("**************************Successfully Login to Account************************** ");

		} catch (Exception e) {

		}
	}
	
	
	
	
	


}
