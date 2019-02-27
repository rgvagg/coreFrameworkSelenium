package SeleniumOverriddenForReporting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import quickStart.selenium.coreFramework.utilities.main.BasePage;

public class SeleniumWait extends BasePage {

	public void implicitWaitForGlobalLevelAllElements(int pageLoadTimeoutInSeconds, int implicitWaitElementTimeoutInSeconds) {
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeoutInSeconds, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitWaitElementTimeoutInSeconds, TimeUnit.SECONDS);
		
	}
	
	public void threadSleep(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void explicitWaitForElementsLevelOnConditions(WebDriver driver, int timeInSeconds, WebElement elementToBeClickable) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void fluentWaitOnElement(WebDriver driver, int timeInSeconds, WebElement elementToBeClickable) {
		Wait wait = new FluentWait<WebDriver>(driver)
				.withTimeout(45, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));

	}
	
}
