package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.IConstants;


public class ReadDataFromExcel 
{
	@DataProvider
	public Object[][] readSetOfData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider33");
		int lastRow = sh.getLastRowNum()+1;
		int lastCol = sh.getRow(0).getLastCellNum();
		Object[][] ar=new Object[lastRow][lastCol];
		for (int i = 0; i < lastRow; i++) 
		{
			for (int j = 0; j < lastCol; j++) 
			{
				ar[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}			
		}
		return ar;
	}
}
