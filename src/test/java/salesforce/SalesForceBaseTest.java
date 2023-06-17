package salesforce;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;

import utilities.Constants;
import utilities.ExtentReportsUtility;
import utilities.Log4jutility;
import utilities.PropertiesUtility;

public class SalesForceBaseTest 
{

	public static WebDriver driver = null;
	public String url = null;
	public String userId = null;
	public String password = null;
	public String EmailName = null;
	public String Emailaddress = null;
	public String accountName = null;
	public String viewName = null;
	public String viewUniqueName = null;
	public String browserType = null; 
	protected Logger log;
	protected Properties appProp = null;
	protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();


	@BeforeTest
	public void setUpForBeforeTest()
	{
		log = LogManager.getLogger(SalesForceBaseTest.class.getName());

	}

	@BeforeMethod
	@Parameters("browsername")
	public void TestInitialize(@Optional("chrome") String browName)
	{
		log = LogManager.getLogger(SalesForceBaseTest.class.getName());
		PropertiesUtility pro=new PropertiesUtility();
		appProp= pro.loadFile("applicationDataProperties");
		this.url=appProp.getProperty("url");
		this.browserType = appProp.getProperty("browserType");
		//launchBrowser(browName);
		goToUrl(url);
		//log.info("TestInitialize completed");
		//report.logTestInfo("TestInitialize completed");
	}

	@AfterMethod
	public void tearDownAfterTestMethod() throws InterruptedException
	{
		driver.close();
		//Thread.sleep(4000);
		log.info("Browser closed");
	}


//	public void launchBrowser(String browserName) 
//	{
//		//launching firefox driver if the browser name is firefox
//		
//		switch(browserName)
//		{
//		case "firefox":
//			if(browserName.equalsIgnoreCase("firefox"))
//			
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				driver.manage().window().maximize();
//				break;
//			
//			
//		case "chrome":
//			if(browserName.equalsIgnoreCase("chrome"))
//			
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				driver.manage().window().maximize();
//				break;
//				
//		case "edge":
//			if(browserName.equalsIgnoreCase("edge"))
//				
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//				driver.manage().window().maximize();
//				break;	
//		}	
//		log.info( browserName + "Browser opened");
//	}
	
//	public void loginSalesforce() throws InterruptedException {
//		userId = appProp.getProperty("login.valid.userid");
//		password = appProp.getProperty("login.valid.password");
//
//		WebElement userName_Field = driver.findElement(By.id("username"));
//		
//		enterText(userName_Field,userId,"username");
//		
//		Thread.sleep(2000);
//		
//		WebElement password_Field = driver.findElement(By.id("password"));
//		
//		ExplicitWaitElement(password_Field);
//		enterText(password_Field,password,"Password");
//		
//		WebElement login = driver.findElement(By.name("Login"));
//		
//		ExplicitWaitElement(login);
//
//		click(login, "Login Button");
//	}

//	public void assertElementTextById(String elementId, String expectedStringValue)
//	{
//		WebElement errorMsgElement = driver.findElement(By.id("error"));
//		Assert.assertEquals(errorMsgElement.getText(), expectedStringValue, "Fail,Error message not matched");
//		ExplicitWaitElement(errorMsgElement);
//		log.info("Error message matched");
//	}
//	
	public void goToUrl(String url)
	{
		driver.manage().window().maximize();
		driver.get(url);
		log.info("Url entered");
	}
	
//	public void assertPageTitle(String expectedTitle)
//	{
//		String actualTitle = driver.getTitle();
//		log.info("Actual title is: " + actualTitle );
//		
//		//comparing the title of the web page
//		Assert.assertEquals(actualTitle, expectedTitle,"Title not matched");
//		log.info("Title matched in the page");
//		
//	}
//	
//	public void enterText(WebElement element, String data, String objectName) 
//	{
//		if(element.isDisplayed())
//		{
//			clearElement(element,objectName);
//			element.sendKeys(data);
//			log.info(objectName + " "+data + " is entered to the field");
//			//report.
//		}
//		
//		else
//		{
//			log.error(objectName + " "+data+" element is not displayed");
//		}
//		
//	}
	
//	public void clearElement(WebElement element, String objName )
//	{
//		if(element.isDisplayed())
//		{
//			element.clear();
//			log.info(objName + "element cleared ");
//		}
//		else
//		{
//			log.error(objName +" element is not cleared");
//		}
//	}
//	
//	protected void click(WebElement element, String buttonName) 
//	{
//		if(element.isDisplayed())
//		{
//			element.click();
//			log.info(buttonName + " is clicked");
//		}
//		
//		else
//		{
//			log.error(buttonName + "is not clicked");
//		}
//		
//	}	
//	
//	protected void actionElement(WebElement element)
//	{
//		Actions action = new Actions(driver);
//		
//		//Performing the mouse hover action on the target element.
//		action.moveToElement(element).perform();
//		
//		log.info("Mouse hovered to " + element.getText() + " menu in the window");
//	}
//	
//	protected void ExplicitWaitElement(WebElement element)
//	{
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
//	
	public static File getScreenshotOfThepage()
	{
		//random value + date()+testcase name-->filename
		
		String date= new SimpleDateFormat("yyyy_MM-dd-hh-mm-ss").format(new Date());
		//String curDir=System.getProperty("user.dir");
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File imgFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH +date +".png");
		
		try
		{
			FileUtils.copyFile(imgFile, destFile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return destFile;
		
	}
	
//	public  void switchToLightningPopup() throws InterruptedException
//	{
//		
//		WebElement noThanks_popup = driver.findElement(By.xpath("//*[@id='lexNoThanks']"));
//
//		ExplicitWaitElement(noThanks_popup);
//
//		click(noThanks_popup, "No Thanks");
//
//
//
//		WebElement submit_popup = driver.findElement(By.xpath("//*[@id='lexSubmit']"));
//
//		ExplicitWaitElement(submit_popup);
//
//		click(submit_popup, "Send TO SalesForce");
//
//	}

	
}

