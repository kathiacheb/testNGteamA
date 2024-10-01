package PageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commons;

public class Checkout_homepage  extends Commons{
	
	//1.constructor:
	public Checkout_homepage() {
		PageFactory.initElements(driver, this);

	}
	//2.locators:
	@FindBy(xpath = "//span[text()='Shopping Cart']") public WebElement shoppingcartbtn; 

	@FindBy (xpath = "//div[@class='pull-right']/a") public WebElement checkoutbtn;
	@FindBy(xpath = "//nav[@id='menu']/div[2]") public WebElement stock;


	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") public WebElement outstockmsg;
	@FindBy(xpath = "//span[@class='text-danger']") public WebElement outstockstars;
	@FindBy(css = "((//td[@class='text-left'])[11]") public WebElement Productnameinshopcart;

	
	//3.action methods
	public void click_ShoppingCart() { 
		isElementDisplayed(shoppingcartbtn);
		drawborder(shoppingcartbtn);
		shoppingcartbtn.click();
	}

  public void click_checkout() {
	  isElementDisplayed(checkoutbtn);
	  drawborder(checkoutbtn);
	checkoutbtn.click();
}
  public void outstockalertmsg() {
	  String stockStatus = stock.getText();	

	isElementDisplayed(outstockmsg);
	drawborder(outstockmsg);
	isElementDisplayed(outstockstars);
	drawborder(outstockstars);
	
	        	Assert.assertTrue("Products are not in stock!",outstockmsg.isEnabled());
				
	        System.out.println(outstockmsg);
	    }
  
  public void outstockmsgs() {
	  String stockStatus = stock.getText();	
		// Check if the product is in stock
	      if (stockStatus.equalsIgnoreCase("In Stock")) {
	          Assert.assertTrue("I should see an option to check out as a guest", checkoutbtn.isEnabled());
	      } else {
	          Assert.assertFalse("The checkout button is disabled", checkoutbtn.isEnabled());
	      }}
  
}
