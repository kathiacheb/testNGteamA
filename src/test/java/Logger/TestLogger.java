package Logger;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogger {
public static WebDriver driver;
public static Logger log;

     public static void main (String[]args) {
    	Logger log= (Logger) LogManager.getLogger(TestLogger.class);
    	
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
