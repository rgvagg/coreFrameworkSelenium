package quickStart.selenium.coreFramework.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import quickStart.selenium.coreFramework.utilities.main.BasePage;

public class HighlightElement extends BasePage{

	public static void highlightElement(WebElement element) {
        for (int i = 0; i <2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
            }
        }
}