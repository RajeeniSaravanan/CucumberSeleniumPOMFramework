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


public class CreateNewViewPage extends BasePage
{
	
	@FindBy(xpath="//div[@class='pbSubbody']//input[@id='fname']") WebElement ViewName;
	@FindBy(xpath="//input[@id='devname']") WebElement ViewUniqueName;
	@FindBy(xpath="//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]") WebElement SaveView;
	
	
	public CreateNewViewPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void enterViewName(String userdata) throws InterruptedException
	{
		Thread.sleep(3000);
		enterText(ViewName, userdata, "View Name");

	}
	
	public void enterViewUniqueName(String userdata)
	{
		enterText(ViewUniqueName, userdata, "View unique Name");
	}
	
	public void saveView()
	{
		SaveView.click();
		log.info("Save button is clicked");
		//report.logTestInfo("Save button is clicked");
	}
}
