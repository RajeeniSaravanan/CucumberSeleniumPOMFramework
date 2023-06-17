package subMenusInHomePage;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import automationbasePage.BasePage;

public class MySettingsPage extends BasePage
{
	@FindBy(css=".PersonalInfo_icon") WebElement personal_link;
	@FindBy(xpath="//*[@id='LoginHistory_font']/span") WebElement login_history;
	@FindBy(xpath="//span[@id='DisplayAndLayout_font']") WebElement DisplayLayoutElement;
	@FindBy(xpath="//*[@id='CustomizeTabs_font']") WebElement custTabs;
	@FindBy(id="tsidButton") WebElement rightDropdown;
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[7]") WebElement salesforceChatter;
	@FindBy(xpath="//div[@id='EmailSetup']") WebElement Email;
	@FindBy(xpath="//span[@id='EmailSettings_font']") WebElement myEmailSettings;
	
	public MySettingsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void personalLink() throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		robot.mouseWheel(2);
		Thread.sleep(3000);
		personal_link.click();
		log.info("Personal link is clicked");
		//report.logTestInfo("Personal link is clicked");

	}
	
	public void loginhistorylink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", login_history);
		js.executeScript("window.scrollBy(0,350)", "");
		log.info("Login history link is clicked");
		//report.logTestInfo("Login history link is clicked");
	}
	
	public void displayAndLayout()
	{
		DisplayLayoutElement.click();
		log.info("Display and Layout link is clicked");
		//report.logTestInfo("Display and Layout link is clicked");
	}
	
	public void customizeMyTabs()
	{
		custTabs.click();
		log.info("Customize my tabs link is clicked");
		//report.logTestInfo("Customize my tabs link is clicked");
	}

	public void rightDropdownMenu() throws InterruptedException 
	{
		rightDropdown.click();
		log.info("Right dropdown is clicked");
		//report.logTestInfo("Right dropdown is clicked");
		
		salesforceChatter.click();
		log.info("Salesforce chatter is clicked");
		//report.logTestInfo("Salesforce chatter is clicked");
		
		switchToLightningPopup();
		
	}

	public void selectEmail() 
	{
		Email.click();
		log.info("Email link is clicked");
		//report.logTestInfo("Email link is clicked");
		
		myEmailSettings.click();
		log.info("My email settings is clicked");
		//report.logTestInfo("My email settings is clicked");
		
	}
	
	

}
