package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelRead;
import Utilities.GeneralUtilities;

public class RegisterAPatient {
	
	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities();
	
	
	public RegisterAPatient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="givenName")
	WebElement givenName;
	
	@FindBy(name="familyName")
	WebElement familyName;
	
	@FindBy(id="next-button")
	WebElement nextButton;
	
	@FindBy(id="gender-field")
	WebElement gender;
	
	@FindBy(id="birthdateDay-field")
	WebElement birthdayDay;
	
	@FindBy(id="birthdateMonth-field")
	WebElement birthMonth;
	
	@FindBy(id="birthdateYear-field")
	WebElement birthYear;
		
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="cityVillage")
	
	WebElement cityVillage;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="postalCode")
	WebElement postalCode;
	
	@FindBy(name="phoneNumber")
	WebElement phoneNumber;
	
	
	@FindBy(id="relationship_type")
	WebElement relationtype;
	
	@FindBy(xpath="//input[contains(@class,'person-typeahead ng-')]")
	WebElement personName;
	
	@FindBy(id="submit")
	WebElement confirmButton;
	
	@FindBy(xpath="//*[@class='PersonName-givenName']")
	WebElement confirmationMessage;

	@FindBy(xpath="//a[contains(@href,'javascript:delPatient.')]")
	WebElement deletePatient;
	
	@FindBy(id="delete-reason")
	WebElement reason;
	
	@FindBy(xpath="(//button[@class='confirm right'])[6]")
	WebElement confirm;
	
	
	@FindBy(xpath="//i[@class='icon-home small']")
	WebElement homePage;
	
	
	public void enterFullname(String gname, String fname)
	{
		gl.typeToAnElement(givenName, gname);
		gl.typeToAnElement(familyName, fname);
		gl.clickOnElement(nextButton);
	}
	
	public void selectGender(int a) {
		gl.selectFromDropDownByIndex(gender,a);
		gl.clickOnElement(nextButton);
	}
	
	public void enterDateOfBirth(String day,int a, String year)
	{
		gl.typeToAnElement(birthdayDay,day);
		gl.selectFromDropDownByIndex(birthMonth,a);
		gl.typeToAnElement(birthYear,year);
		gl.clickOnElement(nextButton);
	}

	
	public void enterAddress(String add1, String add2,String city,String ctry, String post)
	{
		gl.typeToAnElement(address1,add1);
		
		gl.typeToAnElement(address2,add2);
		gl.typeToAnElement(address2,add2);
		gl.typeToAnElement(cityVillage,city);
		
		gl.typeToAnElement(country,ctry);
		gl.typeToAnElement(postalCode,post);
		gl.clickOnElement(nextButton);
	}
	
	public void enterPhone(String phone)
	{
	gl.typeToAnElement(phoneNumber,phone);
	gl.clickOnElement(nextButton);
	}
	
	public void enterRelationshipType(int a,String name)
	{
		gl.selectFromDropDownByIndex(relationtype,a);
	gl.typeToAnElement(personName,name);
	gl.clickOnElement(nextButton);
	}
	
	public void clickOnConfirm()
	{
		gl.clickOnElement(confirmButton);
	
	}
	public String confirmPatientNameIsDisplayed()
	{
	return gl.getTextOfAnElement(confirmationMessage);
}
	public void deleteAPatient(String type)
	{
		gl.clickOnElement(deletePatient);
		 gl.typeToAnElement(reason, type);
		 gl.clickOnElement(confirm);
	}
	
	public String readStringData(int a, int b) throws IOException
	{
		return ExcelRead.getStringData(a, b);
	}
	
  public String readIntData(int a,int b)throws IOException
  {
	  return ExcelRead.getIntegerData(a,b);
  }
  
  public void clickOnHomePage()
  {
	  gl.clickOnElement(homePage);
  }
}
