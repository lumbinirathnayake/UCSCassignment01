package testPackage;

import org.testng.annotations.Test;

import pageObjects.AppointmentConfirmation;
import pageObjects.HomePage;
import pageObjects.LoginPage_PO;
import pageObjects.MakeAppointment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestRunner {

	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@Parameters({ "Browser" })
	@BeforeMethod
	public void beforeMethod(String browse) {

		if (browse.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browse.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setVersion("32.0.1");
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setCapability("marionette", false);
			driver = new FirefoxDriver(capabilities);

		}

		else {
			System.out.println("Browser not initialized");
		}

		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Browser Loaded");
	}

	@Parameters({ "Username", "Password" })
	@Test
	public void testCase01(String username, String Password) {

		HomePage homepage = new HomePage(driver);
		homepage.verifyPageload();
		homepage.navigate();

		LoginPage_PO loginobj = new LoginPage_PO(driver);
		loginobj.verifyPageload();
		loginobj.login(username, Password);

		MakeAppointment makeAppointmentObj = new MakeAppointment(driver);
		makeAppointmentObj.verifyPageload();
		makeAppointmentObj.clickMenubutton();

		makeAppointmentObj.verifyLogOutButton();

	}
	
	
	@Parameters({ "Username", "Password" })
	@Test
	public void testCase02(String username, String Password) {
		
		String facility="Hongkong CURA Healthcare Center";
		String Comment="Sample";

		HomePage homepage = new HomePage(driver);
		homepage.verifyPageload();
		homepage.navigate();

		LoginPage_PO loginobj = new LoginPage_PO(driver);
		loginobj.verifyPageload();
		loginobj.login(username, Password);

		MakeAppointment makeAppointmentObj = new MakeAppointment(driver);
		makeAppointmentObj.verifyPageload();
		makeAppointmentObj.makeAppoinment(facility, Comment);
		
		AppointmentConfirmation confiObj=new AppointmentConfirmation(driver);
		confiObj.verifyValues(facility,Comment);
		confiObj.logout();
		
		confiObj.VerifyMakeAppinment();

	}

	// @Test(dataProvider = "dp")
	// public void f(Integer n, String s) {
	// System.out.println(s);
	// }

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	// @DataProvider
	// public Object[][] dp() {
	// return new Object[][] {
	// new Object[] { 1, "awew" },
	// new Object[] { 2, "bwerre" },
	// };
	// }

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
