package subMenusInHomePage;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import automationHomepages.HomePage;
import automationbasePage.BasePage;


public class SalesforceChatterPage extends BasePage 
{
	@FindBy(xpath="//li[@id='report_Tab']") WebElement reportsTab;
	@FindBy(xpath="//span[@id= 'userNavLabel']") WebElement userMenu;
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[2]") WebElement Mysettings;
	
	public SalesforceChatterPage(WebDriver driver) 
	{
		super(driver);
	}

	public void validateReportsTab(String expectedTab) throws InterruptedException 
	{
		Thread.sleep(3000);
		Assert.assertEquals(reportsTab.getText(), expectedTab, "Reports tab not present");
		log.info("Reports tab present in tab bar");
		//report.logTestInfo("Reports tab present in tab bar");
	}
	
	public void expandDropDown()
	{
		userMenu.click();
		log.info("UserMenu dropdown selected");
		//report.logTestInfo("UserMenu dropdown selected");
	}
	
	public void mySettings()
	{
		Mysettings.click();
		log.info("My Settings menu selected");
		//report.logTestInfo("My Settings menu selected");
	}
	
	
}
