package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ActiveVisit;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatient;

public class ActiveVisitTestClass extends BaseClass{

	
	
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatient rp;
	ActiveVisit ap;
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful")
	public void verifyThePatientIsNotDisplayedInActiveVisitsWhenVisitNotStarted(String uname, String pwd) throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, pwd);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);
		
		String gName=rp.readStringData(5,3);
		String fName=rp.readStringData(6,3);
		rp.enterFullname(gName,fName);
		rp.selectGender(0);
		
		rp.enterDateOfBirth(rp.readIntData(7,1),3, rp.readIntData(8,1));
		rp.enterAddress(rp.readStringData(9, 1), rp.readStringData(10,1), rp.readStringData(11,1), rp.readStringData(12,1), rp.readIntData(13,1));
		rp.enterPhone(rp.readIntData(14,1));
		rp.enterRelationshipType(5, rp.readStringData(15,1));
		rp.clickOnConfirm();
		
		rp.clickOnHomePage();
		
		hp. clickOnActiveVisits();
		ap=new ActiveVisit(driver);
		Boolean actualResult=ap.ifPatientNameDisplayed(gName.concat(fName));
		Assert.assertFalse(actualResult);
		
	}
	
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful")
	public void verifyThePatientIsNotDisplayedInActiveVisitsWhenVisitStarted(String uname, String pwd) throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, pwd);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);
		
		String gName=rp.readStringData(5,3);
		String fName=rp.readStringData(6,3);
		rp.enterFullname(gName,fName);
		rp.selectGender(0);
		
		rp.enterDateOfBirth(rp.readIntData(7,1),3, rp.readIntData(8,1));
		rp.enterAddress(rp.readStringData(9, 1), rp.readStringData(10,1), rp.readStringData(11,1), rp.readStringData(12,1), rp.readIntData(13,1));
		rp.enterPhone(rp.readIntData(14,1));
		rp.enterRelationshipType(5, rp.readStringData(15,1));
		rp.clickOnConfirm();
		
	
		hp.clickOnStartVisit();
		hp. clickOnActiveVisits();
		ap=new ActiveVisit(driver);
		Boolean actualResult=ap.ifPatientNameDisplayed(gName.concat(fName));
		Assert.assertFalse(actualResult);
		
	}
	
	
	
	
	
}