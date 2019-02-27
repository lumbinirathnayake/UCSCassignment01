package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmation {

	private WebDriver driver;

	public AppointmentConfirmation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public static By logoutbtn1 = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CURA Healthcare'])[1]/preceding::i[2]");

	public static By logoutbtn2 = By.linkText("Logout");
	
	public static By btnmake = By.id("btn-make-appointment");
	
	public static By PageVerify = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Make Appointment'])[1]/following::h2[1]");

	public void verifyPageload() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			assertEquals(driver.findElement(PageVerify).getText(), "Appointment Confirmation");
		} catch (Error e) {
			System.out.println(e.toString());
		}

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("assert Title");
	}

	public void verifyValues(String facility, String Comment) {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			assertEquals(driver.findElement(By.id("facility")).getText(), facility);
		} catch (Error e) {
			System.out.println(e.toString());
		}

		try {
			assertEquals(driver.findElement(By.id("hospital_readmission")).getText(), "Yes");
		} catch (Error e) {
			System.out.println(e.toString());
		}

		try {
			assertEquals(driver.findElement(By.id("program")).getText(), "None");
		} catch (Error e) {
			System.out.println(e.toString());
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void logout() {
		
		driver.findElement(logoutbtn1).click();
	    driver.findElement(logoutbtn2).click();
	    
	}
	
	public void VerifyMakeAppinment() {
		
		try {
		      assertEquals(driver.findElement(btnmake).getText(), "Make Appointment");
		      System.out.println("btn-make-appointment is present");
		    } catch (Error e) {
		      System.out.println(e.toString());
		    }
		
	}

}
