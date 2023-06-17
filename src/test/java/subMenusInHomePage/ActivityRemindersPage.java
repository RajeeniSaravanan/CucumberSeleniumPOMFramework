package subMenusInHomePage;

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


public class ActivityRemindersPage extends BasePage
{
	@FindBy(xpath="//input[@id='testbtn']") WebElement openTestRemainder;
	
	
	public ActivityRemindersPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void selectOpenTestReminder() throws InterruptedException
	{
		openTestRemainder.click();
		log.info("Open test reminder is selected");
		//report.logTestInfo("Open test reminder is selected");
		
		String parent_Id = driver.getWindowHandle();
		Set<String> child_Id = driver.getWindowHandles();
			
		for(String a: child_Id)
		
			//System.out.println(a);
			if(!parent_Id.equals(a)) 
			{
				driver.switchTo().window(a);
				Thread.sleep(5000);
				driver.close();	
			}
			
			driver.switchTo().window(parent_Id);
			log.info("Switched to Parent window");
			//report.logTestInfo("Switched to Parent window");
			
	}
	
	

}
