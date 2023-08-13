package pageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.GeneralUtilities;

public class CaptureVitals {
	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities();

	public CaptureVitals(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "referenceapplication.realTime.vitals")
	WebElement captureVitals;
	@FindBy(id = "w8")
	WebElement height;
	@FindBy(id = "w10")
	WebElement weight;
	@FindBy(id = "w12")
	WebElement temperature;
	@FindBy(id = "w14")
	WebElement pulse;
	@FindBy(id = "w16")
	WebElement respiratoryRate;
	@FindBy(id = "w18")
	WebElement bloodPressure;
	@FindBy(id = "w20")
	WebElement bloodPressure2;
	@FindBy(id = "w22")
	WebElement oxygenLevel;
	@FindBy(id = "next-button")
	WebElement nextButton;
	@FindBy(xpath = "//button[@onClick='submitHtmlForm()']")
	WebElement saveButton;
	@FindBy(xpath = "//*[text()='show details']")
	WebElement showDetails;

	@FindBy(xpath = "//*[text()='141.0 cm']")
	WebElement heightText;
	@FindBy(xpath = "//*[text()='50.0 kg']")
	WebElement weightText;
	@FindBy(xpath = "//*[text()='30.0 DEG C']")
	WebElement temparaturetxt;

	@FindBy(xpath = "//*[text()='20 beats/min']")
	WebElement pulseText;

	@FindBy(xpath = "//*[text()='60']")
	WebElement respiratorytxt;
	@FindBy(xpath = "//*[text()='90 mmHg']")
	WebElement bptxt1;
	@FindBy(xpath = "//*[text()='110 mmHg']")
	WebElement bptxt2;
	@FindBy(xpath = "//*[text()='90 %']")
	WebElement oxygenTxt;
	
	public void clickOnCaptureVitals() {

		gl.clickOnElement(captureVitals);

	}

	public void addVitalDetails(String h, String w, String t, String p, String r, String b, String b2, String o) {
		gl.typeToAnElement(height, h);
		gl.clickOnElement(nextButton);
		gl.typeToAnElement(weight, w);
		gl.clickOnElement(nextButton);
		gl.clickOnElement(nextButton);
		gl.typeToAnElement(temperature, t);
		gl.clickOnElement(nextButton);
		gl.typeToAnElement(pulse, p);
		gl.clickOnElement(nextButton);
		gl.typeToAnElement(respiratoryRate, r);
		gl.clickOnElement(nextButton);
		gl.typeToAnElement(bloodPressure, b);
		gl.typeToAnElement(bloodPressure2, b2);
		gl.clickOnElement(nextButton);
		gl.typeToAnElement(oxygenLevel, o);
		gl.clickOnElement(nextButton);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1000)");
		gl.clickOnElement(saveButton);
		gl.clickOnElement(showDetails);

	}

	public String getTheTextOfAlllVitals() {
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1000)");
		gl.scrollToAnElementUsingJs(driver, heightText);
		gl.scrollToAnElementUsingJs(driver, weightText);
		gl.scrollToAnElementUsingJs(driver, temparaturetxt);
		return gl.getTextOfAnElement(heightText)
				.concat(gl.getTextOfAnElement(weightText).concat(gl.getTextOfAnElement(temparaturetxt))
						.concat(gl.getTextOfAnElement(pulseText)).concat(gl.getTextOfAnElement(respiratorytxt))
						.concat(gl.getTextOfAnElement(bptxt1)).concat(gl.getTextOfAnElement(bptxt2)).concat(gl.getTextOfAnElement(oxygenTxt)));
	}

}
