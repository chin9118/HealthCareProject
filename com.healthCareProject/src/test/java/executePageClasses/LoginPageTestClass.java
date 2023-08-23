package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatient;
import retry.RetryAnalyzer;

public class LoginPageTestClass extends BaseClass {
	
	 LoginPageClass lp;
	 HomePageClass hp;
	 RegisterAPatient rp;
	 @Test(retryAnalyzer = RetryAnalyzer.class,groups = {"group1"})
	 public void verifyTheCorrectSiteIsLoadedWhileHittingTheURL() throws IOException
	 {
		 lp=new LoginPageClass(driver);
		String actualResult= lp.getTheUrlOfTheLoginPage();
		System.out.println(actualResult);
		rp=new RegisterAPatient(driver);
		String expectedResult=rp.readStringData(6, 5);
		Assert.assertEquals(actualResult, expectedResult);
		
	 }
	 
  @Test(groups = {"group2"},dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful",retryAnalyzer = RetryAnalyzer.class)
  public void verifySuccessfulLogin(String uname,String pwd) {
	  lp=new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname,pwd);
	  hp=new HomePageClass(driver);
	  String actualResult= hp.getTextOfWelcomeMessage();
	  String expectedResult="Logged in as Super User (admin) at Registration Desk.";
	  Assert.assertEquals(actualResult, expectedResult,"Actual and expected are not same"); //if not success - print msg
  }
  
  
  @Test(groups = {"group2"},dataProviderClass = DataProviderClass.class, dataProvider = "login",retryAnalyzer = RetryAnalyzer.class)
  public void unsuccessfulLogin(String uname,String pass) {
	  lp=new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname,pass);
	  String actualResult= lp.loginAsRegistrationDesk1();
	  String expectedResult="Invalid username/password. Please try again.";
	  Assert.assertEquals(actualResult, expectedResult,"Actual and expected are not same");
	  
  }
  
      
}
  
