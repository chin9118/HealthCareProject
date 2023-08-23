package executePageClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Utilities.ScreenShotClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	ScreenShotClass sc = new ScreenShotClass();
	public static Properties p;

	public static void readProperty() throws IOException {
		p = new Properties();
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		p.load(f);

	}

	@Parameters("browser")
	@BeforeMethod(groups = {"launch"})
	public void beforeMethod(String browserValue) throws IOException {
		readProperty();
		if (browserValue.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}

		else if (browserValue.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(groups = {"close"})
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotClass();
			sc.takeScreenShot(driver, result.getName());
		}

		driver.quit();
	}
	
	@BeforeSuite(alwaysRun = true)
	public void createExtendReport(final ITestContext testContext)
	{
		extentReport.ExtentManager.createInstance().createTest(testContext.getName(),"message");
		
	}

}
