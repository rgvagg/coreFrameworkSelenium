package quickStart.selenium.coreFramework.utilities.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import net.bytebuddy.implementation.bind.annotation.Super;
import quickStart.selenium.coreFramework.utilities.DriverFactory;
import quickStart.selenium.coreFramework.utilities.extentReports.ExtentTestManager;

public class BasePage /*extends RemoteWebElement*/ {
	public static WebDriver driver;
	public static ExtentTest extentTest;
	
	public BasePage() {
		// TODO Auto-generated constructor stub
//		driver = DriverFactory.getDriver();
//		extentTest = ExtentTestManager.getTest();
	}
	
	@BeforeClass
	public void setup() {
		// Create a Chrome driver. All test classes use this.
		driver = DriverFactory.getDriver();
		extentTest = ExtentTestManager.getTest();
		// Maximize Window
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		// close the browser
		//driver.quit();
	}

}