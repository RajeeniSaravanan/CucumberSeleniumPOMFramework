package automationbasePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import salesforce.SalesForceBaseTest;
import utilities.ExtentReportsUtility;
import utilities.Log4jutility;

public class BasePage 
{
	
	protected static WebDriver driver;
	protected WebDriverWait wait;
	//protected Log4jutility logObject = Log4jutility.getInstance();
	//protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	protected Logger log = LogManager.getLogger(SalesForceBaseTest.class.getName());
	
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		System.out.println("driver in basepage = " + driver);
		PageFactory.initElements(driver, this);
		//logObject.getLogger();
	}
	
	
	public void assertElementTextById(String elementId, String expectedStringValue)
	{
		WebElement errorMsgElement = driver.findElement(By.id("error"));
		Assert.assertEquals(errorMsgElement.getText(), expectedStringValue, "Fail,Error message not matched");
		ExplicitWaitElement(errorMsgElement);
		log.info("Error message matched");
	}
	
	public void assertPageTitle(String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		log.info("Actual title is: " + actualTitle );
		
		//comparing the title of the web page
		Assert.assertEquals(actualTitle, expectedTitle,"Title not matched");
		log.info("Title matched in the page");
		
	}
	
	public void enterText(WebElement element, String data, String objectName) 
	{
		if(element.isDisplayed())
		{
			clearElement(element,objectName);
			element.sendKeys(data);
			log.info(objectName + " "+data + " is entered to the field");
			//report.
		}
		
		else
		{
			log.error(objectName + " "+data+" element is not displayed");
		}
		
	}
	
	public void clearElement(WebElement element, String objName )
	{
		if(element.isDisplayed())
		{
			element.clear();
			log.info(objName + "element cleared ");
		}
		else
		{
			log.error(objName +" element is not cleared");
		}
	}
	
	public void click(WebElement element, String buttonName) 
	{
		if(element.isDisplayed())
		{
			element.click();
			log.info(buttonName + " is clicked");
		}
		
		else
		{
			log.error(buttonName + "is not clicked");
		}
		
	}	
	
	protected void actionElement(WebElement element)
	{
		Actions action = new Actions(driver);
		
		//Performing the mouse hover action on the target element.
		action.moveToElement(element).perform();
		
		log.info("Mouse hovered to " + element.getText() + " menu in the window");
	}
	
	protected void ExplicitWaitElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public  void switchToLightningPopup() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement noThanks_popup = driver.findElement(By.xpath("//*[@id='lexNoThanks']"));

		ExplicitWaitElement(noThanks_popup);

		click(noThanks_popup, "No Thanks");



		WebElement submit_popup = driver.findElement(By.xpath("//*[@id='lexSubmit']"));

		ExplicitWaitElement(submit_popup);

		click(submit_popup, "Send TO SalesForce");

	}

}
