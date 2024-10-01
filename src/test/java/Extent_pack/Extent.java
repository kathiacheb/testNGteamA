package Extent_pack;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.utilities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Extent extends utilities{
	  ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark= new ExtentSparkReporter("Results/KathiaExtentReport.html");
	  ExtentTest test;
	
  @Test
   public void addtocart() {
		test= extent.createTest("addtocart").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	test.pass("the product was added to the cart ");
	  }
	  	  
	  
  @Test
  public void confirmationmsg() {
		test= extent.createTest("confirmation_message").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	 test.pass("confirmation message displyed");
  }
  
  @Test
  public void itemsconfirmation() {
		test= extent.createTest("itemsconfirmation").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	 test.pass(" shopping cart increased by one");
  }
  
  @BeforeTest
  public void beforeTest() {
	   extent.attachReporter(spark);
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
