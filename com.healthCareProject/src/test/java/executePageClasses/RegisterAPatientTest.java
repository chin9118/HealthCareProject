package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.FindAPatient;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatient;
import retry.RetryAnalyzer;

public class RegisterAPatientTest extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatient rp;
	FindAPatient fp;

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful",retryAnalyzer = RetryAnalyzer.class)
	public void verifyToRegisterAPatient(String uname, String pwd) throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, pwd);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);
		rp.enterFullname(rp.readStringData(5, 3), rp.readStringData(6, 3));
		rp.selectGender(0);

		rp.enterDateOfBirth(rp.readIntData(7, 1), 3, rp.readIntData(8, 1));
		rp.enterAddress(rp.readStringData(9, 1), rp.readStringData(10, 1), rp.readStringData(11, 1),
				rp.readStringData(12, 1), rp.readIntData(13, 1));
		rp.enterPhone(rp.readIntData(14, 1));
		rp.enterRelationshipType(5, rp.readStringData(15, 1));
		rp.clickOnConfirm();

		String actualresult = rp.confirmPatientNameIsDisplayed();
		String expectedResult = rp.readStringData(5, 3);
		Assert.assertEquals(actualresult, expectedResult);
	}

	@Test(groups = {"group2"},dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful",retryAnalyzer = RetryAnalyzer.class)

	public void verifyTheRegisteredPatientIsFoundOrNotInPatientRecordTable(String uname, String pwd)
			throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, pwd);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);
		String gname = rp.readStringData(5, 2);
		String fname = rp.readStringData(6, 2);
		rp.enterFullname(gname, fname);
		rp.selectGender(0);

		rp.enterDateOfBirth(rp.readIntData(7, 1), 3, rp.readIntData(8, 1));
		rp.enterAddress(rp.readStringData(9, 1), rp.readStringData(10, 1), rp.readStringData(11, 1),
				rp.readStringData(12, 1), rp.readIntData(13, 1));
		rp.enterPhone(rp.readIntData(14, 1));
		rp.enterRelationshipType(5, rp.readStringData(15, 1));
		rp.clickOnConfirm();

		hp.clickOnHomeButton();

		hp.clickOnFindAPatient();
		fp = new FindAPatient(driver);

		Boolean actualResult = fp.ifPatientNameDisplayed(gname.concat(" ").concat(fname));
		System.out.println(gname.concat(" ").concat(fname));
		Assert.assertTrue(actualResult);
	}

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful",retryAnalyzer = RetryAnalyzer.class)
	public void verifyToDeleteRegisteredPatient(String uname, String pwd) throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, pwd);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);
		String gName = rp.readStringData(5, 1);
		String fName = rp.readStringData(6, 1);
		
		rp.enterFullname(gName, fName);

		rp.selectGender(0);

		rp.enterDateOfBirth(rp.readIntData(7, 1), 3, rp.readIntData(8, 1));
		rp.enterAddress(rp.readStringData(9, 1), rp.readStringData(10, 1), rp.readStringData(11, 1),
				rp.readStringData(12, 1), rp.readIntData(13, 1));
		rp.enterPhone(rp.readIntData(14, 1));
		rp.enterRelationshipType(5, rp.readStringData(15, 1));
		rp.clickOnConfirm();

		rp.deleteAPatient("Expired");
		fp = new FindAPatient(driver);
		Boolean actualResult = fp.ifPatientNameDisplayed(gName.concat(fName));
		Assert.assertFalse(actualResult);

	}
}
