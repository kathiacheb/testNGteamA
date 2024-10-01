package PageObjectModel;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.Commons;

public class Login_homepage extends Commons {
	
	//1.constructor
	
	public Login_homepage() {
		PageFactory.initElements(driver, this);
	}
	//2.Login Locators
		@FindBy(name="email")
		public WebElement emailaddress;
		
		@FindBy(name="password")
		public WebElement userpassword;
		
		@FindBy(xpath="//*[@type=\"submit\"]")
		public WebElement loginTab;

		//3.Action methods valid login
		public void emaillogin() {
			emailaddress.clear();
			emailaddress.sendKeys("kukon11674@gmail.com");
		}
		public void passwordenter() {
			userpassword.clear();
			userpassword.sendKeys("Km24@Bww");
		}
		public void loginbutton() {
			waitforclickible(loginTab);
			loginTab.click();
		}
}
