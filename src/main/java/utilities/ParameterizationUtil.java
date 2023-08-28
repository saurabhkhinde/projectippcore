package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ParameterizationUtil {

	static Workbook wbf;
	static FileInputStream file;
	public static String excelStringData(String sheetName,int rowNumber,int cellNumber ) throws EncryptedDocumentException, IOException  
	{     
		String filepath = System.getProperty("user.dir")+"\\TestData\\TestData3.xlsx";
		file=new FileInputStream(filepath);
		Workbook wbf = WorkbookFactory.create(file);
		String data = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getStringCellValue();
		return data;
	}

	public static boolean excelbooleanData(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException 
	{ 
		String filepath = System.getProperty("user.dir")+"\\TestData\\TestData3.xlsx";
		file=new FileInputStream(filepath);
		Workbook wbf = WorkbookFactory.create(file);
		boolean booleanData = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getBooleanCellValue();
		return booleanData;
	}
	public static double excelnumericData(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException 
	{ 
		String filepath = "D:\\eclipse-workspace\\Selenium_august2022\\TestData\\TestData3.xlsx";
		file=new FileInputStream(filepath);
		Workbook wbf = WorkbookFactory.create(file);
		double numericData = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getNumericCellValue();
		return numericData;
	}
	public static String readPropertyFile(String key) throws IOException
	{      
		Properties prop=new Properties();
		String filepath = System.getProperty("user.dir")+"\\constant.properties\\";
		FileInputStream propertyFile = new FileInputStream(filepath);
		prop.load(propertyFile);
		String value = prop.getProperty(key);
		return value;
	}










}
