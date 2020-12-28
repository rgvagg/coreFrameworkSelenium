package quickStart.selenium.coreFramework.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import quickStart.selenium.coreFramework.utilities.extentReports.ExtentTestManager;
import quickStart.selenium.coreFramework.utilities.listeners.EventListenerClass;

public class DriverFactory {
	static private RemoteWebDriver driver = null;
	private static DriverFactory application;

	private DriverFactory() {
		// Just one constructor and that's made private to prevent object creation from
		// outside
	}

	private static void newFirefoxDriver() throws MalformedURLException {
		if (driver == null) {
//			String workingDir = System.getProperty("user.dir");
//			System.setProperty("webdriver.gecko.driver", workingDir + "\\src\\main\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver1 = new FirefoxDriver();

			EventFiringWebDriver driver2 = new EventFiringWebDriver(driver1);
			EventListenerClass eventListenerClass = new EventListenerClass();
			driver2.register(eventListenerClass);


			WrapsDriver wrapperAccess = (WrapsDriver)driver2;
			WebDriver driver3 = wrapperAccess.getWrappedDriver();
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());

//			driver.get("https://www.google.com");




			
			ExtentTestManager.getTest().log(LogStatus.INFO, "New Firefox Driver initialized");
		}

	}

	private static void newChromeDriver() throws MalformedURLException {
		if (driver == null) {
//			String workingDir = System.getProperty("user.dir");
//			System.setProperty("webdriver.chrome.driver", workingDir + "\\src\\main\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();


			WebDriver driver1 = new ChromeDriver();
			EventFiringWebDriver driver2 = new EventFiringWebDriver(driver1);
			
//			WebElementHandler elementHandler = new WebElementHandler(driver1.);
//			
//			EventHandler handler = new EventHandler();

			EventListenerClass eventListenerClass = new EventListenerClass();
			driver2.register(eventListenerClass);


			WrapsDriver wrapperAccess = (WrapsDriver)driver2;
			WebDriver driver3 = wrapperAccess.getWrappedDriver();

			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());


//			ExtentTestManager.getTest().log(LogStatus.INFO, "New Chrome Driver initialized");

			System.out.println("New Chrome driver initialized");
		}

	}

	public static WebDriver getDriver() throws MalformedURLException { // checks if driver is initialized

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