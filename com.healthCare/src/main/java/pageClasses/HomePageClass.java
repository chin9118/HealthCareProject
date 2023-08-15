package pageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExplicitWaitClass;
import Utilities.GeneralUtilities;

public class HomePageClass {

	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[contains(text(),' Logged in as')]")
	WebElement welcomeMessage;

	@FindBy(xpath = "//a[@id='org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension']")
	WebElement activeVisit;

	public String getTextOfWelcomeMessage() {
		return gl.getTextOfAnElement(welcomeMessage);
	}

	@FindBy(xpath = "//a[@class='btn btn-default btn-lg button app big align-self-center']")
	List<WebElement> allTiles;

	public Boolean isAllTilesDisplayedOrNot() {
		for (WebElement element : allTiles) {

			gl.elementIsDisplayed(element);
			return true;
		}
		return false;
	}

	@FindBy(xpath = "//a[contains(@id,'referenceapplication-registrationapp-registerPatient')]")
	WebElement registerAPatient;

	@FindBy(xpath = "(//div[@class='col-11 col-lg-10'])[1]")
	WebElement startVisit;

	@FindBy(id = "start-visit-with-visittype-confirm")
	WebElement confirmButton;

	@FindBy(xpath = "//i[contains(@class,'-home small')]")
	WebElement homeButton;

	@FindBy(xpath = "(//img[contains(@src,'/openmrs/ms/uiframework/resource/')])[1]")

	WebElement logo;
	@FindBy(xpath = "//i[@class='icon-search']")
	WebElement findAPatient;

	public void clickOnRegisterAPatient() {
		gl.clickOnElement(registerAPatient);
	}

	public void clickOnActiveVisits() {
		gl.clickOnElement(activeVisit);
	}

	public void clickOnStartVisit() {
		gl.clickOnElement(startVisit);
		gl.clickOnElement(confirmButton);
		try {
			gl.clickOnElement(homeButton);
		} catch (StaleElementReferenceException e) {
			ew.elementToBeClickableWait(driver, homeButton);
			gl.clickOnElement(homeButton);
		}
	}

	public Boolean logoDisplayed() {
		return gl.elementIsDisplayed(logo);
	}

	public void clickOnHomeButton() {

		ew.elementToBeClickableWait(driver, homeButton);
		gl.clickOnElement(homeButton);
	}

	public void clickOnFindAPatient() {
		ew.elementToBeClickableWait(driver, findAPatient);
		
		gl.clickOnElement(findAPatient);
	}

	public void clickOnStartVisit1() {
		gl.clickOnElement(startVisit);
		gl.clickOnElement(confirmButton);

	}
}
