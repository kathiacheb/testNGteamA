package Logger_pack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjectModel.Addtocart_Homepage;
import utilities.utilities;

public class Addtocart_Test extends utilities {
  @Test
  public void f() throws InterruptedException {
	  
	  Addtocart_Homepage ob= new Addtocart_Homepage();
	  ob.click_AddtoCart();
	  log.info("*************** the product was added to the cart ******************");

	  ob.confirmationtmsg();
      log.info("************** confirmation message displyed *********"); 

	  ob.itemsconfirmation();
	  try {
			
			log.info("*************** shopping cart increased by one ***************");
			
		} catch (Exception e) {
		  System.out.println("The number is increased by One ------- Failed ");
		}
		/*
		 * ob.hoverover(); ob.redborders(); ob.click_multipleproducts();
		 * logger.info("********* all product added to the shopping cart   **********");
		 */

  }
  
  
  
}
