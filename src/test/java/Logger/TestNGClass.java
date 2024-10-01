package Logger;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGClass {
	
	public WebDriver driver;
	Logger log= (Logger)LogManager.getLogger(TestNGClass.class);
  @Test
  public void f() {WebDriverManager.chromedriver().setup();
  log.info("chromedriver setup is complete");
  
  driver= new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  log.info("implicityWait of 10 second");
  
  driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
  log.info("logged into tutorialsninja");
  
  try {
	  WebElement text= driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[7]"));
	  System.out.println(text);
  }
	  catch (Exception e) {
	System.out.println(e.getMessage());
	log.error("exception Occured", new Exception("element not found"));
	  }
  finally {
	driver.quit();
	log.info("quitting the driver");
}
  }
}

