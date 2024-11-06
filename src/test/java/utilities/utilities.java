package utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class utilities extends Commons{

	
	@BeforeTest
	public void beforeTest() {
		extent.attachReporter(spark);
		}
	
	@AfterTest
	public void afterTest() {
		extent.flush();
	}
	// the main roles to run an extent report is to declare @BeforeTest ,and @AfterTest. 
	//inside @BeforeTest we need to delclare extent.attachReporter(spark);
	// inside @AfterTest we need to declare extent.flush();

	
	@Parameters({"browser","website"})
	@BeforeClass	
	 public void beforeClass(String browsername, String urlname ) throws InterruptedException {
	 // public void beforeClass(@Optional("chrome") String browsername,@Optional("https://tutorialsninja.com/demo/index.php?route=account/login") String urlname) throws InterruptedException {
	
	    browser(browsername,urlname);

	  }                   

	  @AfterClass
	  public void afterClass() {
		  log.info("window closed");
		  teardown();

	  }

}
