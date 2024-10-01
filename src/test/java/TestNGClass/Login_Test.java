package TestNGClass;

import org.testng.annotations.Test;

import PageObjectModel.Login_homepage;
import utilities.utilities;

public class Login_Test extends utilities {
  @Test
  public void login() {
	  Login_homepage lg= new Login_homepage();
	  lg.emaillogin();
	  log.info("I enter my email");
	  lg.passwordenter();
	  log.info("user entered the passeword");
	  lg.loginbutton();
	  log.info("Click on login button");
  }
}
