package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/**
 * This class contains methods to access data from excel sheet
 * @author Piyusha Chipare
 *
 */
public class ExcelUtility 
{
/**
 * This method is used to Insert data in Excel sheet
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param data
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public void insertDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(IConstants.excelPath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method is used to Fetch data from Excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		DataFormatter df=new DataFormatter();
		String value = df.formatCellValue(cell);
		return value;
	}
	
	/**
	 * This method is used to get the count of rows in the given sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	/**
	 * This method will fetch a set of data from excel sheet for data provider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@DataProvider
	public Object[][] readSetOfData(String sheetName) throws EncryptedDocumentException, IOException 
	{//3*3
		FileInputStream fis=new FileInputStream(IConstants.excelPath);
		DataFormatter df=new DataFormatter();
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1;//2
		int lastCol = sh.getRow(0).getLastCellNum();
		Object[][]ar=new Object[lastRow][lastCol];
		for (int i = 0; i < lastRow; i++) //row
		{
			for (int j = 0; j < lastCol; j++) //column
			{
				Cell cell = sh.getRow(i).getCell(j);
				ar[i][j]=df.formatCellValue(cell);
			}
		}
		return ar;		
	}
	
	public HashMap<String,String> getMultipleData(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rCount = sh.getLastRowNum();
		HashMap<String, String> map=new HashMap<String, String>();
		for (int i = 0; i <= rCount; i++) 
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
