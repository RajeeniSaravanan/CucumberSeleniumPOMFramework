package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerate 
{
	public static void main(String[] args)
	{
		ExtentReports report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("MySpark.html");
		report.attachReporter(spark);
		
		report.setSystemInfo("Host Name", "Salesforce");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Divyashree");

		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setReportName("firebase regression tests");
		spark.config().setTheme(Theme.DARK);
		
		ExtentTest reportLogger = report.createTest("testscript1");
		reportLogger.log(Status.INFO,"test started");
		reportLogger.log(Status.INFO,"browser launched");
		reportLogger.log(Status.INFO,"url entered");
		reportLogger.log(Status.INFO,"login button clicked");
		reportLogger.log(Status.PASS,"test passed");
		
		ExtentTest reportLogger1 = report.createTest("testscript1");
		reportLogger1.log(Status.INFO,"test started");
		reportLogger1.log(Status.INFO,"browser launched-----------");
		reportLogger1.log(Status.INFO,"url entered------------");
		reportLogger1.log(Status.INFO,"login button clicked----------");
		reportLogger1.log(Status.FAIL,"test failed");
		
		ExtentTest reportLogger2 = report.createTest("testscript1");
		reportLogger2.log(Status.INFO,"test started");
		reportLogger2.log(Status.INFO,"browser launched##########");
		reportLogger2.log(Status.INFO,"url entered##########");
		reportLogger2.log(Status.INFO,"login button clicked###########");
		reportLogger2.log(Status.SKIP,"test skipped");
		
		report.flush();
		System.out.println("completed");
	}
	
	
}
