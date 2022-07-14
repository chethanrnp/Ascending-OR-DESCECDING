package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author HP
 *
 */
public class ExcelUtility {
/**
 * its used to read the data from Excel-Workbook based on below 
 * @param path
 * @param sheet
 * @param r
 * @param c
 * @return
 */
	  public String getDataFromExcelSheet(String path,String sheet,int r,int c) {
			String d=null;
			try {
				FileInputStream fis =new FileInputStream(path);
				Workbook book = WorkbookFactory.create(fis);
				Cell data = book.getSheet(sheet).getRow(r).getCell(c);
				DataFormatter dat=new DataFormatter();
				d=dat.formatCellValue(data);
			} catch (Exception e) {
				
			}
			return d;
		}
	/**
	 * used to write data back to Excel based on below parameter
	 * @param path
	 * @param sheet
	 * @param r
	 * @param c
	 * @param input
	 */
	  public void writeDataIntoexcelSheet(String path,String sheet,int r,int c,String input) {
			String d=null;
			try {
				FileInputStream fis =new FileInputStream(path);
				Workbook book = WorkbookFactory.create(fis);
				book.getSheet(sheet).getRow(r).createCell(c).setCellValue(input);
				FileOutputStream fos=new FileOutputStream(path);
				book.write(fos);
				book.close();
			} catch (Exception e) {
				
			}
			
		}
}
