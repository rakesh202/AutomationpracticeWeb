package com.test.automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

	WebDriver driver;
	public static Logger log=Logger.getLogger(AccountPage.class.getName());
	public AccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Sign out') and @title='Log me out']")
	public WebElement btnsignOut;
	
	@FindBy(xpath = "//span[text()='My addresses']//parent::a")
	public WebElement btnAddress;
	

	/*******************************************************************************
	 * @Function Name : ap_SignOut
	 * @Description : SignOut
	 * @Author Name : Rakesh
	 ********************************************************************************/
	public boolean ap_SignOut(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try{
			wait.until(ExpectedConditions.visibilityOf(btnsignOut));
			btnsignOut.click();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	
}
