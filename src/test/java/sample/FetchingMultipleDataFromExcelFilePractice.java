package sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingMultipleDataFromExcelFilePractice {

	public static void main(String[] args) throws Exception {
//		FileInputStream fis = new FileInputStream("C:\\Users\\SiriG\\Downloads\\Animal.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Animal");
//		DataFormatter df = new DataFormatter();
//		for(int i=1;i<=sh.getLastRowNum();i++) {
//			Row r = sh.getRow(i);
//			for(int j=0;j<r.getLastCellNum();j++) {
//				Cell c = r.getCell(j);
//				String value = df.formatCellValue(c);
//				System.out.print(value+" ");
//			}
//			System.out.println();
//		}
		ExcelUtility eUtil = new ExcelUtility();
		List<String> al = eUtil.getMultipleDataFromExcelFile("Animal", 1, 0);
		System.out.println(al);

	}

}
