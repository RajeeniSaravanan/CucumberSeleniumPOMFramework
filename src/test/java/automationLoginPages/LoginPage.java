package automationLoginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automationbasePage.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(id="username") WebElement userName_Field;
	@FindBy(id="password") WebElement password_Field;
	@FindBy(name="Login") WebElement login;
	@FindBy(id="error") WebElement errorMsgElement;
	@FindBy(id="rememberUn") WebElement checkBox;
	@FindBy(id="idcard-identity") WebElement actualUsername;
	@FindBy(id="forgot_password_link") WebElement forgotPassword;
	@FindBy(id="un") WebElement username;
	@FindBy(id="continue") WebElement continueButton;
	@FindBy(xpath="//div[@id='forgotPassForm']") WebElement forgotPwdConfirmation; 
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void enterUsername(String userdata)
	{
		enterText(userName_Field, userdata, "UserName");
	}
	
	public void enterPassword(String passworddata)
	{
		enterText(password_Field, passworddata, "Password");
		
	}
	
	public void rememberMeCheckbox(boolean bool)
	{
		if(bool = true)
		{
			checkBox.click();
			log.info("Remember me checkbox is clicked");
			//report.logTestInfo("Remember me checkbox is clicked");
		}
		else
		{
			log.info("Remember me checkbox is not clicked");
		}
	}
	
	public void clickButton()
	{
		click(login, "Login Button");
		//return driver;
	}
	
	public void getTitleOfThePage()
	{
		driver.getTitle();
	}

	public void assertUserNameAfterLogout(String expectedUserName) throws InterruptedException 
	{
		Thread.sleep(3000);
		Assert.assertEquals(actualUsername.getText(), expectedUserName,"Not matched");
		log.info("Pass, username present in login page");
		//report.logTestInfo("Pass, username present in login page");
		
	}
	
	public void forgotpassword()
	{
		forgotPassword.click();
		log.info("Forgot password link is clicked");
		//report.logTestInfo("Forgot password link is clicked");
	}
	
//	public void enterUsernameforForgotpassword(String userdata)
//	{
//		enterText(username, userdata, "UserName");
//	}
//	
//	public void continueButton()
//	{
//		continueButton.click();
//		log.info("Continue button is clicked");
//		//report.logTestInfo("Continue button is clicked");
//	}
//	
//	public void checkYourEmail()
//	{
//		if(forgotPwdConfirmation != null)
//			
//			log.info("Passed: Forgot password confirmation message displayed");
//		else
//			log.info("Failed: Forgot password confirmation message not displayed");
//	}
	
	public void errorPopUp(String error)
	{
		Assert.assertEquals(errorMsgElement.getText(), error, "Fail,Error message not matched");
		ExplicitWaitElement(errorMsgElement);
		log.info("Error message matched");
		//report.logTestInfo("Error message matched");
	}
	
}
