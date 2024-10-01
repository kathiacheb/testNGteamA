package PageObjectModel;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Commons;

public class Addtocart_Homepage extends Commons{
	
	//1. locators
		@FindBy(xpath ="(//span[@class='hidden-xs hidden-sm hidden-md'])[7]")
		public WebElement AddtoCartbtn;
		
		@FindBy(xpath="(//span[@class='hidden-xs hidden-sm hidden-md'])[8]")
		public WebElement AddtoCartbtn2;
		
		@FindBy(xpath="(//span[@class='hidden-xs hidden-sm hidden-md'])[9]")
		public WebElement AddtoCartbtn3; 
		
		@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
		public WebElement AlertMessage;
		
		@FindBy(xpath = "//td[@class='text-right']") public WebElement quantity;

		
		@FindBy(xpath ="//span[@id='cart-total']") public WebElement TotalItems;
		
		@FindBy(xpath ="//span[text()='10 item(s) - $1,182.99']") public WebElement TotalItemtext;

		@FindBy(css = "(//a[text()='iMac'])[2]") public WebElement Productname;
		
		@FindBy(xpath = "//div[@class='row']/div/div/div/a/img")
		public WebElement productimage;
		
	    
		@FindBy(xpath = "//p[@class='price']")
	    public WebElement productprice;
		
		@FindBy(xpath = "//span[text()='Shopping Cart']") public WebElement shoppingcartbtn;
	    
	    @FindBy(xpath = "//nav[@id='menu']/div[2]") public WebElement stock;
	    
	    //2. action method
	    public void click_AddtoCart() throws InterruptedException { 
			scrollToElement(AddtoCartbtn);
			AddtoCartbtn.click();
			Thread.sleep(2000); 
			log.info("add to cart button was clicked");
	     }
	    public void confirmationtmsg() {
		    isElementDisplayed(AlertMessage);
            drawborder(AddtoCartbtn);	
            log.info("confirmation msg is confirmed");
		}


        public void itemsconfirmation() {
             String totalitem = "TotalItems";
             isElementDisplayed(TotalItems);
             String totalItemText = TotalItems.getText().trim();
    
               // Split the text by space and assign the first element to totalitem
             String[] itemsArray = totalItemText.split(" ");
             totalitem = itemsArray[0];
    
    // Assert that totalitem is not "0"
    Assert.assertTrue(!totalitem.equals("0"), "Total items should not be zero");
    
    drawborder(TotalItems);
}
public void hoverover() throws InterruptedException {
	hover(AddtoCartbtn); 
}

public void redborders() { 
	// Retrieve the border color after hover
    String borderColor = AddtoCartbtn.getCssValue("border-color");
    
    // Define the expected color (for example, in RGB format)
    String expectedColor = "rgb(255, 0, 0)"; // Red
    
 // Assert that the border color is red
    Assert.assertEquals("The border color is not red", expectedColor, borderColor);

}


public void click_multipleproducts() throws InterruptedException {

		scrollToElement(AddtoCartbtn);
		AddtoCartbtn.click();
		Thread.sleep(3000);
		AddtoCartbtn2.click();
		Thread.sleep(3000);
		AddtoCartbtn3.click();
		Thread.sleep(3000);
}



//3.constructor
 public Addtocart_Homepage() {
	PageFactory.initElements(driver, this);
	
}
}

        