package Datafetch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getdatafromproperties {
public static void main(String[] args) throws IOException {
	//property file
//	FileInputStream fis=new FileInputStream("./TestData/text.properties");
//	Properties prop=new Properties();
//	prop.load(fis);
//	String name=prop.getProperty("ph");
//	System.out.println(name);
	
	/*
	 * prop.put("ph","123456789");
	 * 
	 * FileOutputStream fos = new FileOutputStream("./TestData/text.properties");
	 * prop.store(fos, "This is a sample properties file");
	 */
	
	//Excel File
		//create FIS/FR Type Object
	FileInputStream fis=new FileInputStream("./TestData/TestData.xlsx");
		//Create Respective File Object Type
	Workbook wb = WorkbookFactory.create(fis);
		//Call Read Methods
	String name = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	System.out.println(name);
	String email = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	System.out.println(email);
	
	
}
}
