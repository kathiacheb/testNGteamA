package TestNGClass;

import org.testng.annotations.Test;

import PageObjectModel.Addtocart_Homepage;
import utilities.utilities;

public class Addtocart_Test extends utilities {
	
	
	
  @Test
  public void addtocart() throws InterruptedException {
			
		Addtocart_Homepage ob= new Addtocart_Homepage();
		  
			 test= extent.createTest("addtocart").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
		  ob.click_AddtoCart();
		  log.info("*************** the product was added to the cart ******************");
		  test.pass("the product was added to the cart ");
  }
  
		  @Test
		  public void confirmationmsg() throws InterruptedException {
		Addtocart_Homepage ob= new Addtocart_Homepage();
			
			test= extent.createTest("confirmation_message").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
		  ob.confirmationtmsg();
	      log.info("************** confirmation message displyed *********"); 
	      test.pass("confirmation message displyed ");
		  }
		  
		  @Test
		  public void itemsconfirmation() throws InterruptedException {
		 Addtocart_Homepage ob= new Addtocart_Homepage();

			test= extent.createTest("itemsconfirmation").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
		  ob.itemsconfirmation();
		  try {
				
				log.info("*************** shopping cart increased by one ***************");
				test.pass("shopping cart increased by one ");
			} catch (Exception e) {
			  System.out.println("The number is increased by One ------- Failed ");
			  test.pass("The number is increased by One ------- Failed ");
			}
  }
}
