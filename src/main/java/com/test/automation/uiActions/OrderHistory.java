package com.test.automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistory {
	
	WebDriver driver;
	public static Logger log=Logger.getLogger(OrderHistory.class.getName());
	public OrderHistory(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[text()='Order history']/following-sibling::p")
	public WebElement txtOrderHistory;
	
	
	/*******************************************************************************
	 * @Function Name : ap_OrderHistory
	 * @Description : Order Details Info
	 * @Author Name : Rakesh
	 ********************************************************************************/
	public boolean ap_OrderHistory() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOf(txtOrderHistory));
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	

}
