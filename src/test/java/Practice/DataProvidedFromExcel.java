package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.ExcelForDataProviderUtility;
import com.GenericUtilities.IConstants;

public class DataProvidedFromExcel 
{
	@DataProvider
	public Object[][] getData33() throws EncryptedDocumentException, IOException 
	{
		ExcelForDataProviderUtility edutil=new ExcelForDataProviderUtility();
		
		int rCount = 3;
		int cCount = 3;
		Object [][]ar=new Object[rCount][cCount];
		for(int row=0;row<rCount;row++)
		{
			for(int col=0;col<cCount;col++)
			{
				ar[row][col]=edutil.getDataFromExcel(IConstants.dataProvide, "Sheet33", row, col);
			}
		}
		return ar;
	}
	
	@DataProvider
	public Object[][] getData44() throws EncryptedDocumentException, IOException 
	{
		ExcelForDataProviderUtility edutil=new ExcelForDataProviderUtility();
		int rCount=4;
		int cCount = 4;
		Object [][]ar=new Object[4][4];
		for(int row=0;row<rCount;row++)
		{
			for(int col=0;col<cCount;col++)
			{
				ar[row][col]=edutil.getDataFromExcel(IConstants.dataProvide, "Sheet44", row, col);
			}
		}
		return ar;
	}
	
	
	public Object[][] getData45() throws EncryptedDocumentException, IOException
	{
		ExcelForDataProviderUtility edutil=new ExcelForDataProviderUtility();
		int rCount=4;
		int cCount = 5;
		Object [][]ar=new Object[4][5];
		for(int row=0;row<rCount;row++)
		{
			for(int col = 0;col<cCount;col++)
			{
				ar[row][col]=edutil.getDataFromExcel(IConstants.dataProvide, "Sheet45", row, col);
			}
		}
		return ar;
		
		
	}
}
