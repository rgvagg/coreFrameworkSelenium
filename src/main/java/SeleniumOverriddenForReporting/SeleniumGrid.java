package SeleniumOverriddenForReporting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import quickStart.selenium.coreFramework.utilities.main.BasePage;

public class SeleniumGrid extends BasePage{

	public void name() throws MalformedURLException {
		
	
	String nodeURL="http://localhost:2323/wd/hub";
	DesiredCapabilities ds=DesiredCapabilities.chrome();
	ds.setPlatform(Platform.WINDOWS);
	 RemoteWebDriver driver3=new RemoteWebDriver(new URL(nodeURL),ds);
	 
	
	}
}
