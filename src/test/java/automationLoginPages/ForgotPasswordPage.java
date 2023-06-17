package automationLoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationbasePage.BasePage;

public class ForgotPasswordPage extends BasePage 
{
	@FindBy(id="wrap") WebElement ForgotYourpassword;
	@FindBy(id="un") WebElement username;
	@FindBy(id="continue") WebElement continueButton;
	@FindBy(xpath="//div[@id='forgotPassForm']") WebElement forgotPwdConfirmation;
	
	public ForgotPasswordPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	public void enterUsernameforForgotpassword(String userdata)
	{
		enterText(username, userdata, "UserName");
	}
	
	public void continueButton()
	{
		continueButton.click();
		log.info("Continue button is clicked");
		//report.logTestInfo("Continue button is clicked");
	}
	
	public void checkYourEmail()
	{
		if(forgotPwdConfirmation != null)
			
			log.info("Passed: Check your email message displayed");
		else
			log.info("Failed: Check your email message not displayed");
	}
	

}
