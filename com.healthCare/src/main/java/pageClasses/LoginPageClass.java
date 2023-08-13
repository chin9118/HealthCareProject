package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;
	GeneralUtilities gl=new GeneralUtilities();

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//li[text()='Registration Desk']")
	WebElement registrationDesk;

	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	@FindBy(id="error-message")
	WebElement errorMessage;
	
	public String getTheUrlOfTheLoginPage()
	{
		String currentUrl= gl.getPageCurrentUrl(driver);
		return currentUrl;
		
	}
	
	public void loginAsRegistrationDesk(String uname,String pwd)
	{
		gl.typeToAnElement(username,uname);
		gl.typeToAnElement(password,pwd);
		gl.clickOnElement(registrationDesk);
		gl.clickOnElement(loginButton);		
	}
	
	public String loginAsRegistrationDesk1()
	{
		return	gl.getTextOfAnElement(errorMessage);
		 
	}

}
