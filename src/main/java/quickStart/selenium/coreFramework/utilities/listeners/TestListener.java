package quickStart.selenium.coreFramework.utilities.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import quickStart.selenium.coreFramework.utilities.DriverFactory;
import quickStart.selenium.coreFramework.utilities.extentReports.ExtentManager;
import quickStart.selenium.coreFramework.utilities.extentReports.ExtentTestManager;
import quickStart.selenium.coreFramework.utilities.main.BasePage;

import java.net.MalformedURLException;


public class TestListener extends BasePage implements ITestListener{
 
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    //Before starting all tests, below method runs.
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
//		ExtentTestManager.getTest().log(LogStatus.INFO, "onStart method"+ iTestContext.getName());

        iTestContext.setAttribute("WebDriver", this.driver);
    }
 
    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
//		ExtentTestManager.getTest().log(LogStatus.INFO, "onFinish method"+ iTestContext.getName());

        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
        System.out.println(ExtentManager.saveReportPath);
        driver.quit();

//        try {
//            DriverFactory.getDriver().get("file://"+ExtentManager.saveReportPath);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }
 
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");

        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"Start Test");
    }
  
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed: "+  getTestMethodName(iTestResult) + " succeed");
    }
 
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
 
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = null;
        try {
            webDriver = DriverFactory.getDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);
 
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed " + testClass.toString(),
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
 
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped: "+  getTestMethodName(iTestResult) + " skipped");
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));

    }

}