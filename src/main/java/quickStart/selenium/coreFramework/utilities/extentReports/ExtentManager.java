package quickStart.selenium.coreFramework.utilities.extentReports;

import com.relevantcodes.extentreports.ExtentReports;

import quickStart.selenium.coreFramework.utilities.DateTime;
 
//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
 
public class ExtentManager {
 
    private static ExtentReports extent;
    public static String saveReportPath;
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            saveReportPath = workingDir+"\\ExtentReports\\"+DateTime.uniqueStringStamp()+"\\ExtentReportResults.html";
            extent = new ExtentReports(saveReportPath, true);
        }
        return extent;
    }
}