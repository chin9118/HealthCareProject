package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ActiveVisit;
import pageClasses.CaptureVitals;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatient;

public class CaptureVitalsTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatient rp;
	ActiveVisit ap;
	CaptureVitals cv;

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "loginsuccessful")
	public void verifyThePatientIsNotDisplayedInActiveVisitsWhenVisitStarted(String uname, String pwd)
			throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, pwd);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);

		String gName = rp.readStringData(5, 3);
		String fName = rp.readStringData(6, 3);
		rp.enterFullname(gName, fName);
		rp.selectGender(0);

		rp.enterDateOfBirth(rp.readIntData(7, 1), 3, rp.readIntData(8, 1));
		rp.enterAddress(rp.readStringData(9, 1), rp.readStringData(10, 1), rp.readStringData(11, 1),
				rp.readStringData(12, 1), rp.readIntData(13, 1));
		rp.enterPhone(rp.readIntData(14, 1));
		rp.enterRelationshipType(5, rp.readStringData(15, 1));
		rp.clickOnConfirm();

		hp.clickOnStartVisit1();
		cv = new CaptureVitals(driver);
		cv.clickOnCaptureVitals();
		String height = rp.readIntData(17, 1);
		String weight = rp.readIntData(18, 1);
		String temperature = rp.readIntData(19, 1);
		String pulse = rp.readIntData(20, 1);
		String respiratoryRate = rp.readIntData(21, 1);
		String bloodPressure = rp.readIntData(22, 1);
		String bloodPressure2 = rp.readIntData(23, 1);
		String oxygenSaturation = rp.readIntData(24, 1);
		cv.addVitalDetails(height, weight, temperature, pulse, respiratoryRate, bloodPressure, bloodPressure2,
				oxygenSaturation);
		String actualResult = cv.getTheTextOfAlllVitals();
		System.out.println(actualResult);
		String expectedResult = "141.0 cm50.0 kg30.0 DEG C20 beats/min6090 mmHg110 mmHg90 %";
		Assert.assertEquals(actualResult, expectedResult);
	}
}
