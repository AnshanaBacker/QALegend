package executePageClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.DateUtilityClass;

public class HomePageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	
	
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class,groups= {"Group2"})
  public void verifyUserManagementOptions(String uname,String passwd) {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname,passwd);
	  
	  hp=new HomePageClass(driver);
	  hp.clickEndUser();
	  hp.clickUserManagement();
	  
	  Boolean check=hp.isAllOptionsDisplayed();
	  Assert.assertTrue(check);
	  
	 }
  
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class,groups= {"Group2"})
  public void verifyUserLoginDate(String uname,String passwd) {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname, passwd);
	  
	  hp=new HomePageClass(driver);
	  String expectedLoginDate=hp.getLoginDate();
	  String actualLoginDate=DateUtilityClass.getCurrentDateFormatted(expectedLoginDate);
	  Assert.assertEquals(actualLoginDate, expectedLoginDate);
	  
	  
	  
  }
}
