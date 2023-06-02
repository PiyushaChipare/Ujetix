package com.ObjectRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaScriptUtility;
import com.GenericUtilities.JavaUtility;

public class CreatePackagePage 
{
	public String packageName=null;
	WebDriver driver=null;
	@FindBy(id = "packagename") private WebElement packageNameEdt;
	
	@FindBy(id = "packagetype") private WebElement packageTypeEdt;
	
	@FindBy(id = "packagelocation") private WebElement packageLocationEdt;
	
	@FindBy(id = "packageprice") private WebElement packagePriceEdt;
	
	@FindBy(id = "packagefeatures") private WebElement packageFeaturesEdt;
	
	@FindBy(id = "packagedetails") private WebElement packageDetailsEdt;
	
	@FindBy(id = "packageimage") private WebElement packageImageEdt;
	
	@FindBy(name = "submit") private WebElement createBtn;
	
	@FindBy(xpath = "//button[.='Reset']")private WebElement resetBtn;
	
	@FindBy (xpath = "//div[@class='succWrap']//strong") private WebElement confirmation;
	
	public CreatePackagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPackageNameEdt() {
		return packageNameEdt;
	}

	public WebElement getPackageTypeEdt() {
		return packageTypeEdt;
	}
	
	public WebElement getPackageLocationEdt() {
		return packageLocationEdt;
	}
	
	public WebElement getPackagePriceEdt() {
		return packagePriceEdt;
	}

	public WebElement getPackageFeaturesEdt() {
		return packageFeaturesEdt;
	}
	
	public WebElement getPackageDetailsEdt() {
		return packageDetailsEdt;
	}
	
	public WebElement getPackageImageEdt() {
		return packageImageEdt;
	}
	
	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	public WebElement getResetBtn() {
		return resetBtn;
	}
	
	public WebElement getConfirmation() {
		return confirmation;
	}

	//Business library
	/**
	 * This method is used to create a package
	 * @param driver
	 * @param packagename
	 * @param packagetype
	 * @param packagelocation
	 * @param packageprice
	 * @param packagefeatures
	 * @param packagedetails
	 * @param packageimage
	 */
	public void createPackage(WebDriver driver,String packagename,String packagetype,String packagelocation,String packageprice,String packagefeatures,String packagedetails,String packageimage) 
	{
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		packageNameEdt.sendKeys(packagename);
		packageTypeEdt.sendKeys(packagetype);
		packageLocationEdt.sendKeys(packagelocation);
		packagePriceEdt.sendKeys(packageprice);
		packageFeaturesEdt.sendKeys(packagefeatures);
		packageDetailsEdt.sendKeys(packagedetails);
		packageImageEdt.sendKeys(packageimage);
		jsu.scrollDown();
		createBtn.click();	
	}
	
	/**
	 * This method is used to verify the package creation confirmation status
	 * @return
	 */
	public String confirmationStatus() 
	{
		String status=confirmation.getText();
		return status;
	}
	
	/**
	 * This method will read set of data from excel to create package
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void createPackage() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		JavaUtility ju=new JavaUtility();
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		ExcelUtility eutil=new ExcelUtility();
		HashMap<String, String> demo = eutil.getMultipleData("CreatePackage");
		for(Entry<String, String> set:demo.entrySet())
		{
			if(set.getKey().equalsIgnoreCase("packagename"))
			{packageName=set.getValue()+ju.getRandomNumber();
			driver.findElement(By.id(set.getKey())).sendKeys(packageName);
			Thread.sleep(3000);
			}
			else
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}
		jsu.scrollDown();
		createBtn.click();	
	}	
}
