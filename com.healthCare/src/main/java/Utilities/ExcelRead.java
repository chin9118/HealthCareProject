package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	static FileInputStream f;
	static XSSFWorkbook x;
	static XSSFSheet sh;
	public static String getStringData(int a,int b)throws IOException
	{
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\excel.xlsx");	//set path of file	
		x=new XSSFWorkbook(f);
		sh=x.getSheet("sheet1");
		Row r=sh.getRow(a);
		Cell c=r.getCell(b);
		return c.getStringCellValue();
	}
	public static String getIntegerData(int a,int b) throws IOException
	{
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\excel.xlsx");		
		x=new XSSFWorkbook(f);
		sh=x.getSheet("sheet1");
		Row r=sh.getRow(a);
		Cell c=r.getCell(b);
		
		int in=(int) c.getNumericCellValue();
		//int i=(int) c.getNumericCellValue();
		return String.valueOf(in);
		
	}
	//public static String getIntegerData(int i, int j) {
		// TODO Auto-generated method stub
	//	return null;
	//}
	
}
