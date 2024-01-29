package pageClasses;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.GeneralUtilities;

public class HomePageClass {
	
	
	WebDriver driver;
	
GeneralUtilities gl=new GeneralUtilities();
	
	public HomePageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[contains(text(),'End tour')]")
	WebElement endUser;
	
	@FindBy(xpath="//span[contains(text(),'User Management')]")
	WebElement userManagement;
	
	@FindBy(xpath="//span[contains(text(),'Users')]")
	WebElement users;
	
	@FindBy(xpath="//span[contains(text(),'Roles')]")
	WebElement roles;
	
	@FindBy(xpath="//span[contains(text(),'Sales Commission')]")
	WebElement salesCommissionAgent;
	
	@FindBy(xpath="(//ul[@class='treeview-menu'])[1]")
	List<WebElement> userManagementOptions;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement add;
	
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement loginDate;
	
	public void clickUserManagement()
	{
		gl.toClickElement(userManagement);
	}
	
	public void clickEndUser()
	{
		gl.toClickElement(endUser);
	}
	public String getUrl()
	{
		return gl.getCurrentUrlOfPage(driver);
	}
	
	public Boolean isOptionsDisplayed()
	{
		return gl.elementIsDisplayed(roles);
	}
	 public Boolean isAllOptionsDisplayed()
	    {
	    	for(WebElement e:userManagementOptions)
	    	{
	    		gl.elementIsDisplayed(e);
	    		return true;
	    	}
			
	    	return false;
	    }
	public void clickAdd()
	{
		gl.toClickElement(add);
	}
    public void clickUser()
    {
    	gl.toClickElement(users);
    }
    public String getLoginDate()
    {
    	return gl.getTextOfElement(loginDate);
    }
	
   
}
