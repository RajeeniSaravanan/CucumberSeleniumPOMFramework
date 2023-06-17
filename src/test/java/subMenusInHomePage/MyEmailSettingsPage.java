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


public class MyEmailSettingsPage extends BasePage
{
	
	@FindBy(xpath="//input[@id='sender_name']") WebElement emailName;
	@FindBy(xpath="//input[@id='sender_email']") WebElement emailAddress;
	@FindBy(xpath="//input[@id='auto_bcc1']") WebElement bccRadioButton;
	@FindBy(xpath="//td[@id='bottomButtonRow']/input[1]") WebElement saveEmailSettings;
	@FindBy(xpath="//div[@class='messageText']") WebElement successMessage;
	@FindBy(xpath="//span[@id='CalendarAndReminders_font']") WebElement calendarRemainder;
	@FindBy(xpath="//span[@id='Reminders_font']") WebElement activityRemainders;
	
	
	public MyEmailSettingsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void enterEmailName(String userdata)
	{
		enterText(emailName, userdata, "Email Name");
	}
	
	public void enterEmailAddress(String userdata)
	{
		enterText(emailAddress, userdata, "Email address");
	}
	
	public void selectRadioButton()
	{
		bccRadioButton.click();
		log.info("Bcc radio button clicked");
		//report.logTestInfo("Bcc radio button clicked");
	}
	
	public void saveMyEmailSettings()
	{
		saveEmailSettings.click();
		log.info("Email settings saved");
		//report.logTestInfo("Email settings saved");
	}
	
	public void validateSuccessMessage(String expectedTab) 
	{
		Assert.assertEquals(successMessage.getText(), expectedTab, "Success message not present");
		log.info("Success message present");
		//report.logTestInfo("Success message present");
	}
	
	public void selectCalendarAndRemainders()
	{
		calendarRemainder.click();
		log.info("Calendar and remainders is selected");
		//report.logTestInfo("Calendar and remainders is selected");
		
	}
	
	public void selectActivityReminders()
	{
		activityRemainders.click();
		log.info("Activity reminders is selected");
		//report.logTestInfo("Activity reminders is selected");
	}
	
	
	
	
}
