package com.test.automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment {


	WebDriver driver;
	public static Logger log=Logger.getLogger(Payment.class.getName());
	public Payment(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//a[@title='Proceed to checkout' and not(@rel)]/span")
	public WebElement btnCheckOut;
	
	@FindBy(xpath = "//button[@name='processAddress']/span")
	public WebElement btnAddressCheckOut;
	
	@FindBy(xpath = "//button[@name='processCarrier']/span")
	public WebElement btnCarrierCheckOut;
	
	@FindBy(xpath = "//p[@class='checkbox']//input")
	public WebElement btnCarrierCheckBox;
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	public WebElement btnPayByBankWire;
	
	@FindBy(xpath = "//button[@type='submit']/span[text()='I confirm my order']")
	public WebElement btnConfirmMyOrder;
	
	@FindBy(xpath = "//*[contains(text(),'Your order on My Store is complete')]")
	public WebElement txtOrderComplete;
	
	/*******************************************************************************
	 * @Function Name : ap_Finalcheckout
	 * @Description : Button Final Proceed to checkout 
	 * @Author Name : Rakesh
	 ********************************************************************************/
	public boolean ap_Finalcheckout(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try{
			wait.until(ExpectedConditions.visibilityOf(btnCheckOut));
			btnCheckOut.click();
			wait.until(ExpectedConditions.visibilityOf(btnAddressCheckOut));
			btnAddressCheckOut.click();
			wait.until(ExpectedConditions.visibilityOf(btnCarrierCheckOut));
			btnCarrierCheckBox.click();
			btnCarrierCheckOut.click();
			wait.until(ExpectedConditions.visibilityOf(btnPayByBankWire));
			btnPayByBankWire.click();
			wait.until(ExpectedConditions.visibilityOf(btnConfirmMyOrder));
			btnConfirmMyOrder.click();
			if (txtOrderComplete.isDisplayed()){
				return true;
			}
			else{
			return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}
	
	
}
