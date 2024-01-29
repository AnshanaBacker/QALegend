package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.AddUserClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import utilities.ExcelReadClass;

public class AddUserTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	AddUserClass ad;
	
	
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class)
  public void verifyUserAddedSuccessfully(String uname,String passwd){
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname,passwd);
	  
	  hp=new HomePageClass(driver);
	  hp.clickEndUser();
	  hp.clickUserManagement();
	  hp.clickUser();
	  hp.clickAdd();
	  
	  ad=new AddUserClass(driver);
	  ad.enterPrefix(ad.getPrefix());
	  ad.enterFirstName(ad.getFirstName());
	  ad.enterLastName(ad.getLastName());
	  String email=ad.getEmail();
	  ad.enterEmail(email);
	  ad.selectRole(3);
	  ad.enterUsername(ad.getUName());
	  String passwd1= ad.getPasswd();
	  ad.enterPassword(passwd1);
	  ad.enterConfirmPassword(passwd1);
	  ad.clickSave();
	  
	  
	  Boolean check=ad.isUseremailIDDisplayed(email);
	  Assert.assertTrue(check);
	 
	  
	  
  }
  
  @Test(dataProvider = "SuccessfulLogin",dataProviderClass = DataProviderClass.class)
  public void verifyUserAddedCanSuccessfullyLogin(String uname,String passwd) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.login(uname, passwd);
	  
	  hp=new HomePageClass(driver);
	  hp.clickEndUser();
	  hp.clickUserManagement();
	  hp.clickUser();
	  hp.clickAdd();
	  
	  ad=new AddUserClass(driver);
	  ad.enterPrefix(ExcelReadClass.getStringdata(4,1));
	  ad.enterFirstName(ExcelReadClass.getStringdata(5,1));
	  ad.enterLastName(ExcelReadClass.getStringdata(6,1));
	  ad.enterEmail(ExcelReadClass.getStringdata(7,1));
	  ad.selectRole(3);
	  ad.enterUsername(ExcelReadClass.getStringdata(8,1));
	  ad.enterPassword(ExcelReadClass.getIntegerdata(9,1));
	  ad.enterConfirmPassword(ExcelReadClass.getIntegerdata(10,1));
	  ad.clickSave();
	  ad.clickOnAdminKL();
	  ad.clickOnSignout();
	  
	  lp.enterUsername(ExcelReadClass.getStringdata(8,1));
	  lp.enterPassword(ExcelReadClass.getIntegerdata(9,1));
	  lp.clickLogin();
	  String expectedName=ExcelReadClass.getStringdata(11,1);
	  String actualName=ad.getTextOdAdmin();
	  Assert.assertEquals(actualName,expectedName);
	  
	  
	  
  }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

