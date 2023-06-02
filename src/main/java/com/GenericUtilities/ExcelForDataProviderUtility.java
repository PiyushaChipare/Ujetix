package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelForDataProviderUtility 
{
	/**
	 * This method will fetch data from excel file for data provider
	 * @param dataProviderExcelPath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String dataProviderExcelPath,String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(dataProviderExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		DataFormatter df=new DataFormatter();
		String value = df.formatCellValue(cell);
		return value;
	}
}