package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class ExcelPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		/*FileInputStream fis=new FileInputStream(IConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider33");
		int lastRow = sh.getLastRowNum();//2
		int lastCol = sh.getRow(0).getLastCellNum();
		System.out.println(lastCol+" "+lastRow);*/
		
	}
/*	@Test(dataProvider = "getData")
	public void getData33(String name,String from,String to)
	{
		System.out.println("Name-->  "+name+" From-->  "+from+" To-->  "+to);
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eu=new ExcelUtility();
		Object[][] data = eu.readSetOfData("DataProvider33");
		return data;
	}*/
}
