package salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import automationLoginPages.LoginPage;
import automationHomepages.HomePage;
import subMenusInHomePage.MySettingsPage;
import subMenusInHomePage.CustomizeTabsPage;
import subMenusInHomePage.SalesforceChatterPage;
import subMenusInHomePage.MyEmailSettingsPage;
import subMenusInHomePage.ActivityRemindersPage;
import homePageTabs.AccountsPage;
import homePageTabs.CreateNewViewPage;

@Listeners(utilities.ListenersTest.class)

public class SalesForceAutomationScripts extends SalesForceBaseTest
{
	@Test
	public void case1_LoginErrorMessage() throws InterruptedException
	{	
		log.info("case1_LoginErrorMessage Started"); 
		
		userId=appProp.getProperty("login.valid.userid");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(userId);
		loginPage.clickButton();
		loginPage.assertElementTextById("error", "Please enter your password.");
	}
	
	@Test
	public void case2_Successful_LoginToSalesForce() throws InterruptedException
	{
		log.info("case2_Successful_LoginToSalesForce Started");
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		HomePage homePage = new HomePage(driver);
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		homePage.assertPageTitle(homeExpectedTitle);
			
	}

	@Test
	public void case3_CheckRememberMe() throws InterruptedException
	{
		log.info("case3_CheckRememberMe Started");
		
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.rememberMeCheckbox(true);
		loginpage.clickButton();
		
		HomePage homePage = new HomePage(driver);
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		homePage.assertPageTitle(homeExpectedTitle);
		homePage.expandDropdown();
		homePage.logOut();
		loginpage.assertUserNameAfterLogout(userId);
					
	}
	
	@Test
	public void case4A_ForgotPassword() throws InterruptedException
	{
		log.info("case4A_ForgotPassword Started");
		userId = appProp.getProperty("login.valid.userid");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.forgotpassword();
		//loginpage.enterUsernameforForgotpassword(userId);
		//loginpage.continueButton();
		//loginpage.checkYourEmail();
	}

	@Test
	public void case4B_ForgotPassword() throws InterruptedException
	{
		
		log.info("case4B_ForgotPassword Started");
		
		userId = appProp.getProperty("login.invalid.userid");
		password = appProp.getProperty("login.invalid.password");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		String errorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		loginpage.errorPopUp(errorMsg);
	}
	
	@Test
	public void case5_UserMenuDropdown() throws InterruptedException
	{
		log.info("case5_UserMenu Dropdown Started");
		
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		HomePage homePage = new HomePage(driver);
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		homePage.assertPageTitle(homeExpectedTitle);
		homePage.expandDropdown();
		homePage.displaySubMenus();
	}
	
	@Test
	public void case7_MySettings_UserMenuDropDown() throws InterruptedException, AWTException
	{
		log.info("case7_My settings usermenu dropdown script Started");
		
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");
		EmailName = appProp.getProperty("valid.emailname");
		Emailaddress = appProp.getProperty("valid.emailaddress");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		HomePage homePage = new HomePage(driver);
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		homePage.assertPageTitle(homeExpectedTitle);
		homePage.expandDropdown();
		homePage.mySettings();
		
		MySettingsPage mysettings = new MySettingsPage(driver);
		mysettings.personalLink();
		mysettings.loginhistorylink();
		mysettings.displayAndLayout();
		mysettings.customizeMyTabs();
		
		CustomizeTabsPage customizetabs = new CustomizeTabsPage(driver);
		customizetabs.chooseCustomApp();
		mysettings.rightDropdownMenu();
		
		SalesforceChatterPage saleschatter = new SalesforceChatterPage(driver);
		String expectedTab="Reports";
		saleschatter.validateReportsTab(expectedTab);
		saleschatter.expandDropDown();
		saleschatter.mySettings();
		
		mysettings.selectEmail();
		
		MyEmailSettingsPage emailsetting = new MyEmailSettingsPage(driver);
		
		emailsetting.enterEmailName(EmailName);
		emailsetting.enterEmailAddress(Emailaddress);
		emailsetting.selectRadioButton();
		emailsetting.saveMyEmailSettings();
		
		String expectedSuccessfulMessage ="Your settings have been successfully saved.";

		emailsetting.validateSuccessMessage(expectedSuccessfulMessage);
		emailsetting.selectCalendarAndRemainders();
		emailsetting.selectActivityReminders();
		
		ActivityRemindersPage activereminder = new ActivityRemindersPage(driver);
		activereminder.selectOpenTestReminder();
		
	}
	
	@Test
	public void case8_DeveloperConsole() throws InterruptedException
	{
		log.info("case8_Developer console script Started");
		
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");
		

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		HomePage homePage = new HomePage(driver);
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		homePage.assertPageTitle(homeExpectedTitle);
		homePage.expandDropdown();
		homePage.selectDeveloperConsole();
	}
	
	@Test
	public void case10_CreateAccount() throws InterruptedException
	{
		log.info("case10_create accounts script Started");
		
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");
		accountName = appProp.getProperty("accountname");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		HomePage homePage = new HomePage(driver);
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		homePage.assertPageTitle(homeExpectedTitle);
		
		AccountsPage account = new AccountsPage(driver);
		homePage.selectAccounts();
		
		account.selectNew();
		account.enteraccountName(accountName);
		
		String expectedAccountName = accountName;
		account.validateNewAccountName(expectedAccountName);

	}
	
	@Test
	public void case11_CreateNewView() throws InterruptedException
	{
		log.info("case11_Create new view script Started");
		
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");
		accountName = appProp.getProperty("accountname");
		viewName =  appProp.getProperty("viewname");
		viewUniqueName =  appProp.getProperty("viewuniquename");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		HomePage homePage = new HomePage(driver);
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		homePage.assertPageTitle(homeExpectedTitle);
		homePage.selectAccounts();
		
		AccountsPage account = new AccountsPage(driver);
		account.createNewView();

		CreateNewViewPage view = new CreateNewViewPage(driver);
		view.enterViewName(viewName);
		view.enterViewUniqueName(viewUniqueName);
			
	}
	
	
	
	
}

	
