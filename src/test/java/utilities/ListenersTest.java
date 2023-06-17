package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import salesforce.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import salesforce.SalesForceBaseTest;
import extentreport.ExtentReportGenerate;

public class ListenersTest implements ITestListener
{
	private static ExtentReportsUtility extentReport;
	@Override
	public void onTestStart(ITestResult result) {
		extentReport.startSingleTestReport(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentReport.logTestpassed(result.getMethod().getMethodName()+"is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentReport.logTestFailed(result.getMethod().getMethodName()+"is failed");
		extentReport.logTestFailedWithException(result.getThrowable());
		
//		Don't create a new instance of the SalesForceBaseTest here. 
//		Find a way to pass it as a reference here. 
//		Otherwise, the new SalesForceBaseTest will have a new driver instance
//		Or we need to make the driver as a static field in the SalesForceBaseTest
		//SalesForceBaseTest ob = new SalesForceBaseTest();
		WebDriver driver= SalesForceBaseTest.driver;
		System.out.println("driver got it in listerners utility="+driver);
		
		File imageFile= SalesForceBaseTest.getScreenshotOfThepage();
		byte[] fileContent=null;
		try {
			fileContent = FileUtils.readFileToByteArray(new File(imageFile.getAbsolutePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String imageEncodedString = Base64.getEncoder().encodeToString(fileContent);
		
		extentReport.logTestWithscreenshot(imageEncodedString);	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentReport=ExtentReportsUtility.getInstance();
		extentReport.startExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.endReport();
	}
	
}
