package executePageClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retry.RetryAnalyzer;

public class HomePageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	 
  @Test(dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful", retryAnalyzer = RetryAnalyzer.class)
  public void verifyAllTilesAreDisplayed(String uname,String pwd) {
	  lp=new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname,pwd);
	  hp=new HomePageClass(driver);
	  Boolean actualresult=hp.isAllTilesDisplayedOrNot();
	  Assert.assertTrue(actualresult);
  }
  @Test(groups = {"group1"},dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful",retryAnalyzer = RetryAnalyzer.class)
  
  public void verifyTheLogoIsDisplayedOrNotInHomePage(String uname,String pwd) {
	  
	  lp=new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname,pwd);
	  hp=new HomePageClass(driver);
	  
	 Boolean actualResult= hp.logoDisplayed();
	 Assert.assertTrue(actualResult);
  }

}
