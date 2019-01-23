package quickStart.selenium.coreFramework.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import quickStart.selenium.coreFramework.utilities.extentReports.ExtentTestManager;

public class DriverFactory {
	static WebDriver driver = null;
	private static DriverFactory application;

	private DriverFactory() {
		// Just one constructor and that's made private to prevent object creation from
		// outside
	}

	private static void newFirefoxDriver() {
		if (driver == null) {
//			String workingDir = System.getProperty("user.dir");
//			System.setProperty("webdriver.gecko.driver", workingDir + "\\src\\main\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			ExtentTestManager.getTest().log(LogStatus.INFO, "New Firefox Driver initialized");
		}

	}

	private static void newChromeDriver() {
		if (driver == null) {
//			String workingDir = System.getProperty("user.dir");
//			System.setProperty("webdriver.chrome.driver", workingDir + "\\src\\main\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			ExtentTestManager.getTest().log(LogStatus.INFO, "New Chrome Driver initialized");

			System.out.println("New Chrome driver initialized");
		}

	}

	public static WebDriver getDriver() { // checks if driver is initialized

		getInstance();
		String browser;
		try {
			browser = ReadProperty.readProperty("browser").toLowerCase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			browser = "chrome";
		}
		
		if (driver == null) {
			
			//if driver not initialized check browser property or initialize chrome
			
			if (browser.contains("firefox")) {
				newFirefoxDriver();
			}

			if (browser.contains("chrome")) {
				newChromeDriver();
			}
			

		}
		return driver;
	}

	private static DriverFactory getInstance() { // checks if instance is already made previously else create the only
												// instance
		if (application == null) {
			application = new DriverFactory();
		}
		return application;
	}

}