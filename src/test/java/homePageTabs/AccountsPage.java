package homePageTabs;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

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

public class AccountsPage extends BasePage
{
	@FindBy(xpath="//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input") WebElement  NewElement;
	@FindBy(xpath="//input[@id='acc2']") WebElement  AccountName;
	@FindBy(xpath="//select[@id='acc6']") WebElement  Type;
	@FindBy(xpath="//select[@id='acc6']/option[7]") WebElement TechnologyPartnerElement;
	@FindBy(xpath="//select[@id='00NHs00000DsHrp']") WebElement CustomerPriorityElement;
	@FindBy(xpath="//select[@id='00NHs00000DsHrp']/option[2]") WebElement SelectPriority;
	@FindBy(xpath="//*[@id=\"bottomButtonRow\"]/input[1]") WebElement SaveElement;
	@FindBy(xpath="//div[@id='contactHeaderRow']//h2") WebElement savedAccountName;
	@FindBy(xpath="//*[@id=\"filter_element\"]/div/span/span[2]/a[2]") WebElement CreateNewView;
	
	
	public AccountsPage(WebDriver driver) 
	{
		super(driver);	
	}
	
	public void selectNew() throws InterruptedException
	{
		Thread.sleep(4000);
		NewElement.click();
		log.info("New element is clicked");
		//report.logTestInfo("New element is clicked");	
	}
	
	public void enteraccountName(String userdata)
	{
		enterText(AccountName, userdata, "Email Name");
		
		Type.click();
		log.info("Type dropdown is clicked");
		//report.logTestInfo("Type dropdown is clicked");	
		
		TechnologyPartnerElement.click();
		log.info("Technology Partner is selected in type");
		//report.logTestInfo("Technology Partner is selected in type");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		CustomerPriorityElement.click();
		log.info("Customer priority is clicked");
		//report.logTestInfo("Customer priority is clicked");
		
		SelectPriority.click();
		log.info("Priority is selected");
		//report.logTestInfo("Priority is selected");
		
		js.executeScript("window.scrollBy(0,350)", "");
		
		SaveElement.click();
		log.info("Save button is clicked");
		//report.logTestInfo("Save button is clicked");
			
	}
	
	public void validateNewAccountName(String expectedname) 
	{
		Assert.assertEquals(savedAccountName.getText(), expectedname, "Success message not present");
		log.info("Pass,account name added");
		//report.logTestInfo("Pass,account name added");
	}
	
	public void createNewView()
	{
		CreateNewView.click();
		log.info("Create new view is clicked");
		//report.logTestInfo("Create new view is clicked");
	}
	
	

}
