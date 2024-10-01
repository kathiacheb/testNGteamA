package TestNGClass;

import org.testng.annotations.Test;

import PageObjectModel.Checkout_homepage;
import utilities.utilities;

public class Checkout_Test extends utilities{
  @Test
  public void f() {
	  
	  Checkout_homepage ob2=new Checkout_homepage();
	  ob2.click_ShoppingCart();
	  log.info("user clicked on shopping cart button");
	  ob2.click_checkout();
	  log.info("user clicked on checkout button");
	  ob2.outstockmsgs();
	  log.info("checkout as a guest option");

  }
}
