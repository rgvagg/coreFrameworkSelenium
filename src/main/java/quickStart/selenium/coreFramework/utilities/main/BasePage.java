package quickStart.selenium.coreFramework.utilities.main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentTest;

import quickStart.selenium.coreFramework.utilities.DriverFactory;
import quickStart.selenium.coreFramework.utilities.extentReports.ExtentTestManager;

import java.net.MalformedURLException;

public class BasePage {
	public static WebDriver driver;
	public static ExtentTest extentTest;
	
	public BasePage() {
		// TODO Auto-generated constructor stub
//		driver = DriverFactory.getDriver();
//		extentTest = ExtentTestManager.getTest();
	}
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		// Create a Chrome driver. All test classes use this.
		driver = DriverFactory.getDriver();
		extentTest = ExtentTestManager.getTest();
		// Maximize Window
		driver.manage().window().maximize();
	}
	@BeforeClass
	public void setup12() {
		// Create a Chrome driver. All test classes use this.
	System.out.println("CheckBeforeClassC2");
	}
	

	@AfterClass
	public void teardown() {
		// close the browser
		//driver.quit();
	}

}