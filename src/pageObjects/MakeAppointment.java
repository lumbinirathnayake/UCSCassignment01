package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class MakeAppointment {

	private WebDriver driver;

	public static By AppoinmentPageverifyText = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Make Appointment'])[1]/following::h2[1]");

	public static By menuButton = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CURA Healthcare'])[1]/preceding::i[2]");
	
	public static By FacilityDrpDwn =  By.id("combo_facility");
	
	public static By checkBoxHospital =  By.id("chk_hospotal_readmission");
	
	public static By radioProgram = By.id("radio_program_none");
	
	public static By commentTxt =By.id("txt_comment");
	
	public static By bookAppoinment = By.id("btn-book-appointment");
	
	public MakeAppointment(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public void verifyPageload() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			assertEquals(driver.findElement(AppoinmentPageverifyText).getText(), "Make Appointment");
			System.out.println("assert Appoinment Page");
		} catch (Error e) {
			System.out.println(e.toString());
		}

		System.out.println("Appoinment Page");
	}

	public void clickMenubutton() {

		driver.findElement(menuButton).click();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyLogOutButton() {

		try {
		      assertEquals(driver.findElement(By.linkText("Logout")).getText(), "Logout");
		      System.out.println("Logout button is Present"); 
		    } catch (Error e) {
		      System.out.println(e.toString()); 
		    }

	}
	
	public void makeAppoinment(String facility, String Comment) {
		
		driver.findElement(FacilityDrpDwn).click();
		
		Select Facility = new Select(driver.findElement(FacilityDrpDwn));
		Facility.selectByVisibleText(facility);
		
	    driver.findElement(checkBoxHospital).click();
	    driver.findElement(radioProgram).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Visit Date (Required)'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::td[33]")).click();
	    driver.findElement(commentTxt).click();
	    driver.findElement(commentTxt).clear();
	    driver.findElement(commentTxt).sendKeys(Comment);
	    
	    driver.findElement(bookAppoinment).click();
	}

}
