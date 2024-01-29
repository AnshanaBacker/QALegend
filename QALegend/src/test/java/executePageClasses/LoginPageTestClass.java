package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPageTestClass extends BaseClass {
	
	
	LoginPageClass lp;
	HomePageClass hp;
	GeneralUtilities gl;
	
  @Test(dataProvider = "UnSuccessfulLogin",dataProviderClass = DataProviderClass.class,groups= {"Group1"})
  public void verifyUnSuccessfulLogin(String uname,String passwd) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname,passwd);
	  
	  gl=new GeneralUtilities();
	  String expectedMessage=ExcelReadClass.getStringdata(2,2);
	  String actualMessage=lp.gettextOfErrorMessage();
	  Assert.assertEquals(actualMessage, expectedMessage);
	  
	  
  }
  
	
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class,groups= {"Group1"})
  public void verifySuccessfulLogin(String uname,String passwd) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname,passwd);
	  
	  gl=new GeneralUtilities();
	  hp=new HomePageClass(driver);
	  String expectedUrl=ExcelReadClass.getStringdata(2,1);
	  String actualUrl=hp.getUrl();
	  Assert.assertEquals(actualUrl, expectedUrl);
	  
	  
  }
	  
}
