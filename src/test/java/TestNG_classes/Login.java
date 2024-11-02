package TestNG_classes;

import org.apache.poi.hssf.util.HSSFColor.GREEN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utilities.utilities;

public class Login extends utilities{
	
  @Test(priority = 1)
  public void loginpage() {
test= extent.createTest("login page").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");

     WebElement email= driver.findElement(By.name("email"));
     email.click();
     email.clear();
     email.sendKeys("kukon11674@gmail.com");
     log.info("email entered");
     test.info("email entered");

     test.log(Status.PASS, MarkupHelper.createLabel("enter email", ExtentColor.GREEN));
      test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "enter email");     
  }
  
  
  @Test(priority = 2)
  public void passwordenter() {
	  WebElement userpassword= driver.findElement(By.name("password"));
		userpassword.click();
		userpassword.clear();
		userpassword.sendKeys("Km24@Bww");
		log.info("password entered");
		test.info("password entered");

		test.log(Status.PASS, MarkupHelper.createLabel("enter password", ExtentColor.GREEN));
	      test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "enter password");     

	}
  
  
  @Test(priority = 3)
	public void loginbutton() {
		try {
			WebElement loginbtn= driver.findElement(By.xpath("//input[@type='submit']"));
		loginbtn.click();
	     Thread.sleep(1000);

		log.info("login btn clicked");
		test.info("login btn clicked");
		test.log(Status.PASS, MarkupHelper.createLabel("login btn clicked", ExtentColor.GREEN));
	      test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "clicked on loginbtn succeeded");     


		} catch (Exception e) {
			log.info("test failed");
			test.info("test failed");

			test.log(Status.FAIL, MarkupHelper.createLabel("login btn clicked", ExtentColor.RED));
		      test.addScreenCaptureFromPath(Captureforss("Allfailed"), "click on loginbtn failed");     


		} 
		
	}
@Test(priority = 4)
  public void search() throws InterruptedException {
test= extent.createTest("search").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	  WebElement search= driver.findElement(By.xpath("//input[@name='search']"));
	  search.click();
	  search.clear();
	  search.sendKeys("mac");
	     Thread.sleep(1000);

      
	  WebElement searchbtn= driver.findElement(By.xpath("(//button[@type='button'])[4]"));
	  searchbtn.click();
	  log.info("search for mac");
	  test.info("search for mac");
	test.log(Status.PASS, MarkupHelper.createLabel("search for mac", ExtentColor.GREEN));
    test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "search for mac");     

	  
	  }

@Test(priority = 5)
public void click_AddtoCart() throws InterruptedException {
test= extent.createTest("click_AddtoCart").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	  
	  WebElement addtocart= driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[7]"));
	  scrollToElement(addtocart);
	     Thread.sleep(1000);
	  addtocart.click();
	     Thread.sleep(500);

  //  drawborder(addtocart);
	  log.info("user clicked on add to cart button");
	test.pass("add to cart button was clicked succesfully");
		test.log(Status.PASS, MarkupHelper.createLabel("addtocart btn clicked", ExtentColor.GREEN));
	      test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "click on add to cart");     

 

}

@Test(priority = 6)
public void confirmationmsg() throws InterruptedException {
	test= extent.createTest("confirmation_message").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
   log.info("confirmation message displyed");
   test.info("confirmation message displyed");

   WebElement alertmsg= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
   scrollIntoView(driver, alertmsg);
   Thread.sleep(1000);
   isElementDisplayed(alertmsg);
  // drawborder(alertmsg);
	test.log(Status.PASS, MarkupHelper.createLabel("message confirmed", ExtentColor.GREEN));
    test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "confirmation msg displayed");     


}
@Test(priority=7)
public void itemsconfirmation() throws InterruptedException {
	test= extent.createTest("items confirmation").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	log.info("total items increased");
	WebElement Totalitems= driver.findElement(By.xpath("//span[@id='cart-total']"));
	  String totalitem= "Totalitems";
      isElementDisplayed(Totalitems);
      Thread.sleep(1000);

      String totalItemText = Totalitems.getText().trim();

        // Split the text by space and assign the first element to totalitem
      String[] itemsArray = totalItemText.split(" ");
      totalitem = itemsArray[0];

// Assert that totalitem is not "0"
Assert.assertTrue(!totalitem.equals("0"), "Total items should not be zero");

//drawborder(Totalitems);
test.log(Status.PASS, MarkupHelper.createLabel("mtotal items increased", ExtentColor.GREEN));
test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "confirmation increased items");     

}


}
