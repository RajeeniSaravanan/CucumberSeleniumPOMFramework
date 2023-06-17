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

public class CustomizeTabsPage extends BasePage
{
	@FindBy(xpath="//*[@id='p4']") WebElement custApp;
	@FindBy(xpath="//*[@id='duel_select_0']") WebElement availTabs;
	@FindBy(xpath="//*[@id='duel_select_0_right']/img") WebElement addToTab;
	@FindBy(xpath="//*[@id='bottomButtonRow']/input[1]") WebElement saveBtn;
	
	public CustomizeTabsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void chooseCustomApp() throws InterruptedException
	{

		Select selectCustApp = new Select(custApp);
		selectCustApp.selectByVisibleText("Salesforce Chatter");
		log.info("Salesforce chatter is clicked");
		//report.logTestInfo("Salesforce chatter is clicked");

		Select selectAvailTabs = new Select(availTabs);
		Thread.sleep(3000);
		selectAvailTabs.selectByVisibleText("Reports");
		log.info("Reports tab from available tabs is selected");
		//report.logTestInfo("Reports tab from available tabs is selected");

		addToTab.click();
		log.info("Reports tab added to selected tabs");
		//report.logTestInfo("Reports tab added to selected tabs");
		
		saveBtn.click();
		log.info("Customized tab settings is saved");
		//report.logTestInfo("Customized tab settings is saved");
		

		
		
		
	}
	
	
	
}
