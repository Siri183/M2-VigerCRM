package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
/**
 * This is generic class which deals with Excel file
 * @author SiriG
 * @version 07-03-2025S
 */

public class ExcelUtility {
	/**
	 * This method is used to get data from Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws Exception
	 */
	public String getDataFromExcelFile(String sheetName,int rowIndex,int cellIndex) throws Exception{
		FileInputStream fis=new FileInputStream(IPathUtility.excelPath);
	    Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row r=sh.getRow(rowIndex);
		Cell c=r.getCell(cellIndex);
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(c);
		return value;
		
	}
	/**
	 * This method is used to get multiple data from Excel file
	 * @param sheetName
	 * @param startRowIndex
	 * @param startCellIndex
	 * @return
	 * @throws Exception
	 */
	public List<String> getMultipleDataFromExcelFile(String sheetName,int startRowIndex,int startCellIndex) throws Exception {
		FileInputStream fis=new FileInputStream(IPathUtility.excelPath);
	    Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		List<String> a1=new ArrayList<String>();		
		for(int i=startRowIndex;i<=sh.getLastRowNum();i++) {
			Row r=sh.getRow(i);
			for(int j=startCellIndex;j<r.getLastCellNum();j++) {
				Cell c=r.getCell(j);
				String value=df.formatCellValue(c);
				a1.add(value);
			
			}
			
		}
		return a1;
	}
	
	/**
	 * This method is used to write data to the excel file.
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param value
	 * @throws Exception
	 */
	public void writeDataToExcelFile(String sheetName,int rowIndex,int cellIndex,String value) throws Exception {
		FileInputStream fis = new FileInputStream("‪‪‪D:\\Animal.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row r=sh.createRow(rowIndex);
		Cell c=r.createCell(cellIndex);
		c.setCellValue(value);
		FileOutputStream fos = new FileOutputStream("‪D:\\Animal.xlsx");
		wb.write(fos);
		
	}

}