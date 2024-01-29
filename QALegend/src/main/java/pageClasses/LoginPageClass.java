package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public LoginPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	@FindBy(className="help-block")
	WebElement errorMessage;
	
	public void login(String uname,String passwd)
	{
		gl.toTypeElement(username,uname);
		gl.toTypeElement(password, passwd);
		gl.toClickElement(login);
		
	}
	
	
	public String gettextOfErrorMessage()
	{
		return gl.getTextOfElement(errorMessage);
	}
	
	public void enterUsername(String uname1)
	{
		 gl.toTypeElement(username,uname1);
	}
	public void enterPassword(String passwd1)
	{
		gl.toTypeElement(password, passwd1);
	}
	public void clickLogin()
	{
		gl.toClickElement(login);
	}

}
