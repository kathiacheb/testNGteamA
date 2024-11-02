package utilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Commons extends javascriptutilities {
     
	public static final int ELEMENT_POLLING_TIME_MILIS = 50;
   
	 public WebDriver driver;
     String ud= System.getProperty("user.dir");
     public Logger log= LogManager.getLogger(Commons.class);

     public ExtentReports extent = new ExtentReports();
	 public  ExtentSparkReporter spark = new ExtentSparkReporter("Results/KathiaExtentReport"+System.currentTimeMillis()+".html");
	 public ExtentTest test;

	 

public  void browser(String browsername, String urlname) throws InterruptedException {

if(browsername.equalsIgnoreCase("chrome")) {

	WebDriverManager.chromedriver().setup();
	log.info("launched browser");

    try {
	driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(urlname);
    driver.manage().window().maximize();
    log.info("maximize window");
    Thread.sleep(2000);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("chrome opened");
	} 
}

else if (browsername.equalsIgnoreCase("edge")) {


	WebDriverManager.edgedriver().setup();
	log.info("launch edge browser");

	try {
	driver= new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(urlname);
	driver.manage().window().maximize();
	log.info("maximize window");
	Thread.sleep(2000);
	 
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("edge opened");
	} 
}
}

public void switchtoOpenedWindow(String Parent) throws InterruptedException {
	  
	 Set<String> wins = driver.getWindowHandles();
	 for(String sesid:wins) {
		 if (sesid!=Parent) {
			 driver.switchTo().window(sesid);
			 log.info("Window switched- Driver is present in the new Window/Tab");
}
} 
}

public void waitfortitle(String pagetitle) {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofHours(1));
	wait.until(ExpectedConditions.titleContains(pagetitle));
}
public void waitforclickible(WebElement element) {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofHours(1));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	log.info("waiting for element to be clickable");
}

public void implicitywait(){
	WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(30));
}
public void Verifypagetitle(String expectedtitle) {
	String actualpagetitle= driver.getTitle();
	Assert.assertEquals(actualpagetitle, expectedtitle, "pagetitle verified");
	log.info("******pagetitle verified*****");
	
}

public void configreport() {
	extent.attachReporter(spark);
	extent.setSystemInfo("machine", "pc");
	extent.setSystemInfo("Os", "windows");   //operationnal system
	extent.setSystemInfo("browser", "chrome");
	extent.setSystemInfo("username", "kathia");
	
	//look change
	spark.config().setTheme(Theme.DARK); //to change the backround
	spark.config().setDocumentTitle("kathia's report"); // to change the name of the report
}

public void screenshot(String foldername) {
	
	File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destinationpath= new File(ud+"\\pictures\\"+foldername+"\\"+System.currentTimeMillis()+"home.jpg");
	try {
		FileHandler.copy(ss, destinationpath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info("screenshot captured..");
}
public String Captureforss (String foldername) {
	
	File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destinationpath= new File(ud+"\\pictures\\"+foldername+"\\"+System.currentTimeMillis()+"home.jpg");
	try {
		FileHandler.copy(ss, destinationpath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info("screenshot captured for extent Report");
	//we need to return the absolute part first 
	String absolutepath = destinationpath.getAbsolutePath();
	//we have to return it since we have a return method
	return absolutepath;
}

	

public void scrollToElement(WebElement element) {

	((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");

}

public boolean isElementDisplayed(WebElement locator) {

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	// .implicitlyWait(0, TimeUnit.SECONDS);

	log.info("Checking visibility of the Element on browser screen");

	try {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))

				.pollingEvery(Duration.ofMillis(ELEMENT_POLLING_TIME_MILIS))

				.ignoring(Exception.class);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver arg0) {

				Boolean isPresent = false;

				if (locator.isDisplayed()) {

					isPresent = true;

					log.info("Wait for the element is completed, Element is visible on the screen");
				}

				return isPresent;
			}

		};

		boolean e = wait.until(function);

		return e;

	} catch (Exception e) {

		return false;

	}

}

   

public void teardown() {
	
	try {
		driver.close();
	} catch (Exception e) {
		System.out.println("Driver is closed");
	}
	

}
}

