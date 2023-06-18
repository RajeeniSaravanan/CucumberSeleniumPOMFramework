package com.CucumberTest.steps;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import automationHomepages.HomePage;
import automationLoginPages.ForgotPasswordPage;
import automationLoginPages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Log4jutility;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import utilities.PropertiesUtility;



public class SalesforceStepDef
{
	protected static Logger log;
	public static WebDriver driver;
	protected static Log4jutility logObject=Log4jutility.getInstance();
	LoginPage login;
	HomePage home;
	ForgotPasswordPage forgotpassword;
	public String userId = null;
	public String password = null;
	public String inValidUserId = null;
	public String inValidPassword = null;
	
	public void launchBrowser(String browserName) 
	{
		//launching firefox driver if the browser name is firefox
		
		switch(browserName)
		{
		case "firefox":
			if(browserName.equalsIgnoreCase("firefox"))
			
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			
			
		case "chrome":
			if(browserName.equalsIgnoreCase("chrome"))
			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
				
		case "edge":
			if(browserName.equalsIgnoreCase("edge"))
				
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;	
		}	
		log.info( browserName + "Browser opened");
	}
	
	public void goToUrl(String url)
	{
		//driver.manage().window().maximize();
		driver.get(url);
		log.info("Url entered");
	}
	
	public void closeBrowser() throws InterruptedException
	{
		driver.close();
		Thread.sleep(3000);
		log.info("Browser closed");
	}
	
	@BeforeAll
	public static void setUpBeforeAllScenarios() 
	{
		log=logObject.getLogger();
		System.out.println("Before all scenarios gets executed");
	}
	@Before
	public void setUpEachScenario() 
	{
		
		launchBrowser("chrome");
		
	}
	@After
	public void tearDown() throws InterruptedException 
	{
		closeBrowser();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		  scenario.attach(fileContent, "image/png", "screenshot");
		}
		
	}
	
	@Given("application is up and running and in loginPage")
	public void application_is_up_and_running_and_in_login_page() 
	{
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");
		inValidUserId = appProp.getProperty("login.invalid.userid");
		inValidPassword = appProp.getProperty("login.invalid.password");
		String url= appProp.getProperty("url");
		goToUrl(url);
		log.info("driver in baseTest="+driver);
	}
	
	@When("user on {string}")
	public void user_on(String page) 
	{
		if(page.equalsIgnoreCase("loginpage"))
	    	login=new LoginPage(driver);
	    else if(page.equalsIgnoreCase("homepage"))
	    	home=new HomePage(driver);
	    else if(page.equalsIgnoreCase("forgotpasswordpage"))
	    	forgotpassword=new ForgotPasswordPage(driver);
	}

	@When("user enters username and leave the password field empty")
	public void user_enters_username_and_leave_the_password_field_empty()
	{
		login.enterUsername(userId);
		login.enterPassword("");
	}

	@When("click on the login button")
	public void click_on_the_login_button() 
	{
	    login.clickButton();
	}

	@Then("Error message should be displayed in Loginpage and validate the error message")
	public void error_message_should_be_displayed_in_loginpage_and_validate_the_error_message() 
	{
		String error="Please enter your password.";
	    login.errorPopUp(error);
	}
	
	@When("user enters correct username and correct password")
	public void user_enters_correct_username_and_correct_password() 
	{
		login.enterUsername(userId);
		login.enterPassword(password);	
	}

	@Then("Validate the home page title")
	public void validate_the_home_page_title() 
	{
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		home.assertPageTitle(homeExpectedTitle);
	}	
	
	@When("select the rememberme checkbox")
	public void select_the_rememberme_checkbox() 
	{
		login.rememberMeCheckbox(true);
	}

	@Then("user click on the usermenu dropdown")
	public void user_click_on_the_usermenu_dropdown() 
	{
		home.expandDropdown();
	}

	@Then("click on the logout")
	public void click_on_the_logout() 
	{
		home.logOut();
	}

	@Then("validate the username field in the loginpage")
	public void validate_the_username_field_in_the_loginpage() throws InterruptedException 
	{
		login.assertUserNameAfterLogout(userId);
	}
	
	@When("user clicks on forgot password link")
	public void user_clicks_on_forgot_password_link() 
	{
		login.forgotpassword();
	}

	@When("user provide username in forgot password page")
	public void user_provide_username_in_forgot_password_page() 
	{
		forgotpassword.enterUsernameforForgotpassword(userId);
	}
	
	@When("click on the continue button")
	public void click_on_the_continue_button() 
	{
		forgotpassword.continueButton();
	}

	@Then("password reset message is displayed")
	public void password_reset_message_is_displayed() 
	{
		forgotpassword.checkYourEmail();
	}

	@When("When user enters incorrect username and incorrect password")
	public void when_user_enters_incorrect_username_and_incorrect_password() 
	{
		login.enterUsername(inValidUserId);
		login.enterPassword(inValidPassword);
	}

	@Then("error message should be displayed in loginpage")
	public void error_message_should_be_displayed_in_loginpage() 
	{
		String errorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		login.errorPopUp(errorMsg);
	}
	
	@When("user click on for user menu dropdown in homepage")
	public void user_click_on_for_user_menu_dropdown_in_homepage() 
	{
	    home.expandDropdown();
	}

	@Then("user menu dropdown list is displayed")
	public void user_menu_dropdown_list_is_displayed() 
	{
	    home.displaySubMenus();
	}
	

}
