package automationHomepages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import automationbasePage.BasePage;

public class HomePage extends BasePage
{
	@FindBy(xpath="//span[@id='userNavLabel']") WebElement dropDown;
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[5]") WebElement logout;
	@FindBy(xpath="//div[@id=\"userNav-menuItems\"]/a") List<WebElement> subMenu;
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[2]") WebElement mySettings;
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[3]") WebElement DeveloperConsole;
	@FindBy(xpath="//li[@id='Account_Tab']") WebElement accounts;
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void expandDropdown()
	{
		dropDown.click();
		log.info("UserMenu dropdown selected");
		//report.logTestInfo("UserMenu dropdown selected");
	}
	
	public void logOut()
	{
		logout.click();
		log.info("Logout menu selected");
		//report.logTestInfo("Logout menu selected");
		
	}
	
	public void mySettings()
	{
		mySettings.click();
		log.info("My Settings menu selected");
		//report.logTestInfo("My Settings menu selected");
	}
	
	public void displaySubMenus()
	{
		String subControlMenu[] = {"My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience", "Logout"};
		for(int i=0; i<subControlMenu.length; i++)
		{
			if(subMenu.get(i).getText().equalsIgnoreCase(subControlMenu[i])) 
			{
				log.info("Passed: " + subMenu.get(i).getText() + " Menu found");
				//report.logTestInfo("Passed: " + subMenu.get(i).getText() + " Menu found");
			}
			else
				log.info("Failed: " + subMenu.get(i).getText() + " Menu not found" );
				//report.logTestInfo("Passed: " + subMenu.get(i).getText() + " Menu not found");
		
		}
	}
	
	public void selectDeveloperConsole() throws InterruptedException
	{
		DeveloperConsole.click();
		log.info("Developer console menu selected");
		//report.logTestInfo("Developer console menu selected");
		
		String parent_Id = driver.getWindowHandle();
		Set<String> child_Id = driver.getWindowHandles();
			
		for(String a: child_Id)
		
			//System.out.println(a);
			if(!parent_Id.equals(a)) 
			{
				driver.switchTo().window(a);
				Thread.sleep(5000);
				driver.close();	
				log.info("Developer console closed");
			}
			
			driver.switchTo().window(parent_Id);
			log.info("Passed: Switched to Previous window");
			//report.logTestInfo("Passed: Switched to Previous window");
	}
	
	public void selectAccounts() throws InterruptedException
	{
		Thread.sleep(3000);
		accounts.click();
		log.info("Accounts tab selected");
		//report.logTestInfo("Accounts tab selected");
		
		switchToLightningPopup();
	}
	
}
