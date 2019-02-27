package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public static By btnAppointment = By.id("btn-make-appointment");
	
	
	public void verifyPageload() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			assertEquals(driver.getTitle(), "CURA Healthcare Service");
			System.out.println("Home page loaded");
		} catch (Error e) {
			System.out.println(e);
		}
		
		System.out.println("assert Title Home page");
	}
	
	
	public void navigate()
	{
		WebElement makeAppointment_Btn = driver.findElement(btnAppointment);
		
		makeAppointment_Btn.click();
		System.out.println("makeAppointment_Btn clicked"); 
	}
	
	
	// makeAppointment_Btn.click();
	

	

}
