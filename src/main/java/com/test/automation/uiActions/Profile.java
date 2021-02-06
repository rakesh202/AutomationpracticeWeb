package com.test.automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile {

	WebDriver driver;
	public static Logger log=Logger.getLogger(Profile.class.getName());
	public Profile(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@title='View my customer account']")
	public WebElement linkCustomerAccount;
	
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]/parent::a")
	public WebElement linkOrderHistory;
	
	
	/*******************************************************************************
	 * @Function Name : ap_CustomerOrderHistory
	 * @Description : Customer Order Details 
	 * @Author Name : Rakesh
	 ********************************************************************************/
	
	public boolean ap_CustomerOrderHistory(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try{
			wait.until(ExpectedConditions.visibilityOf(linkCustomerAccount));
			linkCustomerAccount.click();
			wait.until(ExpectedConditions.visibilityOf(linkOrderHistory));
			linkOrderHistory.click();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	
}
