package com.test.automation.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Clothes {
	
	WebDriver driver;
	public static Logger log=Logger.getLogger(Clothes.class.getName());
	public Clothes(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Women objWomenElement=new Women(driver);
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	public WebElement txtQuantity;
	
	@FindBy(xpath = "//label[contains(text(),'Size')]/parent::fieldset//select")
	public WebElement selectSize;
	
	@FindBy(xpath = "//a[@title='Yellow']")
	public WebElement colorYellow;
	
	
	@FindBy(xpath = "//button[@name='Submit']")
	public WebElement btnAddCart;
	
	@FindBy(xpath = "//span[@title='Continue shopping']/span")
	public WebElement btnContinueshopping;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']/span")
	public WebElement btnProceedtocheckout;
	
	
	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']//img")
	public WebElement imgFirst;
	
	@FindBy(xpath = "//div[contains(@class,'layer_cart_product')]//h2")
	public WebElement Shoppingcart;
	
	@FindBy(xpath = "//div[@class='layer_cart_product_info']//span")
	public List<WebElement> CartInfo;
	
	/*******************************************************************************
	 * @Function Name : ap_AddToCart
	 * @Description : Add Dress to Cart 
	 * @Author Name : Rakesh
	 ********************************************************************************/
	public boolean ap_AddToCart(WebElement element) {
		JavascriptExecutor ObjJavascriptExecutor = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//List<WebElement> objAllSummerDress=driver.findElements(By.xpath("//a[@title='Printed Summer Dress']//img"));
		//Women objWomen=new Women(driver);
		
		try {
		
			wait.until(ExpectedConditions.visibilityOf(element));
			//elementImage.click();
			ObjJavascriptExecutor.executeScript("arguments[0].click();", element);
			wait.until(ExpectedConditions.visibilityOf(txtQuantity));
			txtQuantity.clear();
			txtQuantity.sendKeys("5");
			selectSize.click();
			Select dropdownunCountry = new Select(selectSize);
			dropdownunCountry.selectByVisibleText("S");
			
			btnAddCart.click();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/*******************************************************************************
	 * @Function Name : ap_ContinueShopping
	 * @Description : Button Continue Shopping 
	 * @Author Name : Rakesh
	 ********************************************************************************/
	public boolean ap_ContinueShopping(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try{
			
			wait.until(ExpectedConditions.visibilityOf(btnContinueshopping));
			btnContinueshopping.click();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	
	/*******************************************************************************
	 * @Function Name : ap_Proceedtocheckout
	 * @Description : Button Proceed to checkout 
	 * @Author Name : Rakesh
	 ********************************************************************************/
	public boolean ap_Proceedtocheckout(){
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try{
			
			wait.until(ExpectedConditions.visibilityOf(btnProceedtocheckout));
			
			Assert.assertEquals("Product successfully added to your shopping cart", Shoppingcart.getText().toString());
			for(WebElement element:CartInfo){
				log.info("-------------------"+element.getText().toString()+"-------------------");
				
			}
			
			btnProceedtocheckout.click();
			
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	/*******************************************************************************
	 * @Function Name : ap_FirstItem
	 * @Description : Button Proceed to checkout 
	 * @Author Name : Rakesh
	 ********************************************************************************/
	public boolean ap_FirstItem() {
		Women objWomen=new Women(driver);
		try {
			ap_AddToCart(imgFirst);
			ap_Proceedtocheckout();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	

	
	
	
}
