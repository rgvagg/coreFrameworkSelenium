package quickStart.selenium.coreFramework.utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import quickStart.selenium.coreFramework.utilities.extentReports.ExtentManager;
import quickStart.selenium.coreFramework.utilities.extentReports.ExtentTestManager;
import quickStart.selenium.coreFramework.utilities.main.BasePage;

public class ScreenShots extends BasePage {
	public static void capture() throws MalformedURLException {
		WebDriver webDriver = DriverFactory.getDriver();

		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);

		extentTest.log(LogStatus.INFO, "Pass screen capture" + ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

	}

	public static void capture2() throws IOException {
		WebDriver webDriver = DriverFactory.getDriver();

		File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(srcFile, new File(ExtentManager.dateFolderString + DateTime.uniqueStringStamp() + ".jpeg"));
		extentTest.log(LogStatus.INFO, "Test screen capture" + ExtentTestManager.getTest()
				.addScreenCapture(ExtentManager.dateFolderString + DateTime.uniqueStringStamp() + ".jpeg"));

	}
}