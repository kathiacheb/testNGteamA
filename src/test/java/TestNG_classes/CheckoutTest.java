package TestNG_classes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;
import utilities.utilities;

public class CheckoutTest extends utilities {
	
  @Test(priority = 1)
  public void LoginToMyAccout() {
	  test= extent.createTest("login page").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");

	     WebElement email= driver.findElement(By.name("email"));
	     email.click();
	     email.clear();
	     email.sendKeys("kukon11674@gmail.com");
	     log.info("email entered");
	     test.info("email entered");
	     WebElement userpassword= driver.findElement(By.name("password"));
		 userpassword.click();
		 userpassword.clear();
		 userpassword.sendKeys("Km24@Bww");
		 log.info("password entered");
		 test.info("password entered");
		 WebElement loginbtn= driver.findElement(By.xpath("//input[@type='submit']"));
		 loginbtn.click();
		 log.info("login btn clicked");
		 test.info("login btn clicked");

	     test.log(Status.PASS, MarkupHelper.createLabel("login btn clicked", ExtentColor.GREEN));
	      test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "enter email");   
  }
  
  @Test(priority = 2)
  public void click_shopping_card() throws InterruptedException {
	  test= extent.createTest("shopping cart").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	  log.info("shopping cart clicked");
	  test.info("shopping cart clicked");
	  WebElement shoppingcartbtn= driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
	  isElementDisplayed(shoppingcartbtn);
	  shoppingcartbtn.click();
	  Thread.sleep(1000);

	  test.log(Status.PASS, MarkupHelper.createLabel("shopping cartbtn clicked", ExtentColor.GREEN));
      test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "shopping cart");     

  }
  @Test(priority = 3)
  public void click_checkout() throws InterruptedException {
	  test= extent.createTest("click on checkoutbtn").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	  log.info("clicked on checkout");
	  test.info("checkout clicked");
	  WebElement checkoutbtn= driver.findElement(By.xpath("//a[text()='Checkout']"));
	  scrollToElement(checkoutbtn);
	  Thread.sleep(1000);
	  isElementDisplayed(checkoutbtn);	  
	  waitforclickible(checkoutbtn);
	  checkoutbtn.click();

	  test.log(Status.PASS, MarkupHelper.createLabel("checkout btn clicked", ExtentColor.GREEN));
      test.addScreenCaptureFromPath(Captureforss("Allsucceed"), "checkout btn");     

	  
  }
}
