package quickStart.selenium.coreFramework.utilities.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.relevantcodes.extentreports.LogStatus;

import quickStart.selenium.coreFramework.utilities.main.BasePage;

public class EventListenerClass extends BasePage implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Trying to accept an alert");
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Alert accepted");

		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Alert dismissed");

		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Trying to dismiss an alert");

		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Trying to navigate to URL: " + url);

		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Able to navigate to URL: " + url);
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Trying to navigate back");

		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Navigated back" + driver.getCurrentUrl());

		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		extentTest.log(LogStatus.INFO, "Trying to navigate forward");

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		extentTest.log(LogStatus.PASS, "Navigated forward" + driver.getCurrentUrl());

		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Trying to refresh the web page");

		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		extentTest.log(LogStatus.PASS, "Web page refreshed successfully");

		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Trying to locate an element"); // +element.getTagName()+"
																		// text:"+element.getText()/*+ " locating by: "+
																		// by.toString()*/);
		// TODO Auto-generated method stub

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		extentTest.log(LogStatus.PASS, "Locate the element with tagname:" + element.getTagName() + " text:"
				+ element.getText() + " located by: " + by);

		// TODO Auto-generated method stub

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Trying to click on element"); // with tagname:"+element.getTagName()+"
																		// text:"+element.getText());
		// TODO Auto-generated method stub

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		extentTest.log(LogStatus.PASS, "Clicked successfully on element "); // with tagname:"+element.getTagName()+"
																			// text:"+element.getText());

		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		extentTest.log(LogStatus.INFO, "Trying to change value of element with tagname:" + element.getTagName()
				+ " text:" + element.getText() + " New value: " + keysToSend);
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		extentTest.log(LogStatus.PASS, "Changed value of element with tagname:" + element.getTagName() + " text:"
				+ element.getText() + " New value: " + keysToSend);

		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		extentTest.log(LogStatus.INFO, "Exception encountered: " + throwable.getMessage());

		// TODO Auto-generated method stub

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
	}

}