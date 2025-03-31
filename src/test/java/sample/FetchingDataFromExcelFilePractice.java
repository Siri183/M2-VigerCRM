package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingDataFromExcelFilePractice {

	public static void main(String[] args) throws Exception {
//		FileInputStream fis = new FileInputStream("C:\\Users\\SiriG\\OneDrive\\Desktop\\Animal.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Fish");
//		Row r = sh.getRow(5);
//		Cell c = r.getCell(2);
//		String value = c.getStringCellValue();
//		DataFormatter df = new DataFormatter();
//		String value = df.formatCellValue(c);
//		
//		System.out.println(value);
//		System.out.println(value+1832);
		
		ExcelUtility eUtil = new ExcelUtility();
//		String value = eUtil.getDataFromExcelFile("Animal", 2, 1);
//		String value1 = eUtil.getDataFromExcelFile("Fish", 3, 1);
		String value = eUtil.getDataFromExcelFile("Leads", 1, 1);
		String value1 = eUtil.getDataFromExcelFile("contacts", 4, 1);
		System.out.println(value);
		System.out.println(value1);
		
		
		
		
		

	}

}
