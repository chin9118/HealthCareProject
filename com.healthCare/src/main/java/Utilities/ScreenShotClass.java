package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotClass {

	
	public void takeScreenShot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File screenShotFile=ts.getScreenshotAs(OutputType.FILE);
		
		String dest = System.getProperty("user.dir") + "//Test_Evidence"; // create a folder inside project
		File f1 = new File(dest);
		if (!f1.exists()) {//check if folder exists otherwise create a new folder
			f1.mkdirs();
		}
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			
			String destinationPath = System.getProperty("user.dir") + "//Test_Evidence//" + name + timeStamp + ".png";
			File finalDestination = new File(destinationPath);
			FileHandler.copy(screenShotFile, finalDestination);
		
		}
}
