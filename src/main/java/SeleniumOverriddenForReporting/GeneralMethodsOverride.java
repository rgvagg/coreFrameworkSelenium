package SeleniumOverriddenForReporting;

import com.relevantcodes.extentreports.LogStatus;

import quickStart.selenium.coreFramework.utilities.main.BasePage;

public class GeneralMethodsOverride extends BasePage{


	public void click() {
		extentTest.log(LogStatus.PASS, "clicked successfully");
	}
	
	
}