/*package quickStart.selenium.FacebookAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import quickStart.selenium.FacebookAutomation.tests.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(id = "email")
	private WebElement emailTextbox;

	@FindBy(id = "pass")
	private WebElement passwordTextbox;

	@FindBy(id = "u_0_2")
	private WebElement loginButton;

	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public void enterEmailId(String emailId) {
		extentTest.log(LogStatus.INFO, "Entering Email Id");
		if (emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys(emailId);
			extentTest.log(LogStatus.PASS, "Email ID step", "Able to enter email ID");
		}
	}

	public void enterPassword(String password) {
		extentTest.log(LogStatus.INFO, "Entering Password");
		passwordTextbox.sendKeys(password);
		extentTest.log(LogStatus.PASS, "Password step", "Able to enter password");
	}

	public void clickLoginButton() {
		extentTest.log(LogStatus.INFO, "Click Log In");
		loginButton.click();
		extentTest.log(LogStatus.PASS, "Click Log In Button step", "Login button Clicked successfully");
	}

}
*/