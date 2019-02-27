package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_PO {
	private WebDriver driver;

	public LoginPage_PO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public static By usernametxt = By.id("txt-username");

	public static By pwd = By.id("txt-password");

	public static By btnlogin = By.id("btn-login");
	
	public static By loginPageverifyText = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Login'])[2]/following::p[1]");

	
	
	
	public void verifyPageload() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			
			assertEquals(driver.findElement(loginPageverifyText).getText(), "Please login to make appointment.");
			System.out.println("Login page loaded");
			
		} catch (Error e) {
			System.out.println(e);
		}

		System.out.println("assert Title Login page");
	}

	public void login(String username, String Password) {
		
		WebElement username_txtbx = driver.findElement(usernametxt);

		username_txtbx.click();
		username_txtbx.clear();
		username_txtbx.sendKeys(username);
		
		WebElement pwd_txtbx = driver.findElement(pwd);

		pwd_txtbx.click();
		pwd_txtbx.clear();
		pwd_txtbx.sendKeys(Password);

		driver.findElement(LoginPage_PO.btnlogin).click();
		System.out.println("Login Button Clicked");
	}

}
