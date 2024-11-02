package TestNG_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.utilities;

public class AddtocartTest extends utilities{
  @Test
  public void click_AddtoCart() throws InterruptedException {
	  test= extent.createTest("click_AddtoCart").assignAuthor("kathia").assignCategory("smoketestcase").assignDevice("window");
	  
	  WebElement addtocart= driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[7]"));
	  scrollToElement(addtocart);
	  addtocart.click();
	  log.info("user clicked on add to cart button");
	  test.pass("add to cart button was clicked succesfully");
	  

  }
}
