package com.test.automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Women {

	
	WebDriver driver;
	public static Logger log=Logger.getLogger(Women.class.getName());
	public Women(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//@FindBy(xpath = "//a[text()='Women']")
	//public WebElement btnWomen;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a[@title='T-shirts']")
	public WebElement Tshirts;
	
	@FindBy(xpath = "//div[@id='block_top_menu']//ul[contains(@style,'display') and not(@class)]//a[text()='Summer Dresses']")
	public WebElement linkSummerDresses;
	
	@FindBy(xpath = "//ul[contains(@class,'display')]")
	public WebElement txtView;
	
	@FindBy(xpath = "//ul[contains(@class,'display')]/li[@id='list']")
	public WebElement linkList;
	
	@FindBy(xpath = "(//a[@title='Printed Summer Dress']//img)[1]")
	public WebElement imgFirst;
	
	@FindBy(xpath = "(//a[@title='Printed Summer Dress']//img)[2]")
	public WebElement imgSecond;
	
	
	
	/*******************************************************************************
	 * @Function Name : ap_SummerDressListView
	 * @Description : Click Summer Dress and Click List View 
	 * @Author Name : Rakesh
	 ********************************************************************************/

	public boolean ap_TshirtstView() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Actions objAction = new Actions(driver);
		try {

			log.info("**************** Goto Women T-shirts ****************");
			Tshirts.click();
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
}
