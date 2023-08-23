package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload {
	public void fileUpload() throws AWTException
	{
		Robot robot=new Robot();
		StringSelection filePath=new StringSelection("C:\\Users\\Jishnu\\Desktop\\Super_ex.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(2);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(2);
		
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("File upload successful");
			}

	}


