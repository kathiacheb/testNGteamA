package Extent_pack;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import utilities.utilities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Extent extends utilities{
	 // ExtentReports extent = new ExtentReports();
	 // ExtentSparkReporter spark= new ExtentSparkReporter("Results/KathiaExtentReport.html");
	 // ExtentTest test;
	
	  
	  @Test (priority = 1)
	   public void login() {
			test= extent.createTest("login").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
			test.info("user is logged in succesfully ");

			test.pass("logged in succesfully ");
		  } 
	  
	  @Test (priority = 2)
	  public void search() {
		  test= extent.createTest("search").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
		  test.info("search started");
		  test.pass("search for mac succeded");

	  }  
  @Test (priority = 3)
   public void addtocart() {
		test= extent.createTest("addtocart").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	test.info("add the product to the cart");
	test.pass("the product was added to the cart ");
	test.log(Status.PASS, MarkupHelper.createLabel("addtocart btn clicked", ExtentColor.GREEN));

	  }
	  	  
	  
  @Test (priority = 4)
  public void confirmationmsg() {
		test= extent.createTest("confirmation_message").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	    test.info("the confirmation is displayed");
		test.pass("confirmation message displyed");
  }
  
  @Test (priority = 5)
  public void itemsconfirmation() {
		test= extent.createTest("itemsconfirmation").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	    test.info("shopping cart encreased");
		test.pass(" shopping cart increased by one");
  }
  
	/*
	 * @BeforeTest public void beforeTest() { extent.attachReporter(spark); }
	 * 
	 * @AfterTest public void afterTest() { extent.flush(); }
	 */

}
