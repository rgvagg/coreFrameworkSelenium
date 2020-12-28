package SeleniumOverriddenForReporting;

import java.util.Collections;
import java.util.Queue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import quickStart.selenium.coreFramework.utilities.main.BasePage;

public class GeneralMethodsOverride extends BasePage{


	public void click(WebElement element) {
		element.click();
		extentTest.log(LogStatus.PASS, element.getText()+ element.getTagName() +"clicked successfully");
	}
	
	public void explicitWaitMethod() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
	}
	
//	Queue<E>
//	Collection
	
}