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

public class PackageDetailsPage 
{
	WebDriver driver;
	@FindBy (xpath = "//input[@id='datepicker']") private WebElement startDateEdt;
	
	@FindBy (xpath = "//label[.='To']/following-sibling::input") private WebElement endDateEdt;
	
	@FindBy (xpath = "//label[.='Comment']/following-sibling::input[@class='special']") private WebElement commentEdt;
	
	@FindBy (xpath = "//button[.='Book']") private WebElement bookBtn;
	
	@FindBy (xpath = "//div[@class='succWrap']//strong") private WebElement bookingConfirmation;

	public PackageDetailsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getCommentEdt() {
		return commentEdt;
	}

	public WebElement getBookBtn() {
		return bookBtn;
	}
	
	public WebElement getBookingConfirmation() {
		return bookingConfirmation;
	}

	//Business Library
	/**
	 * This method is used to book a package with given details
	 * @param driver
	 * @param startDate
	 * @param endDate
	 * @param comment
	 */
	public void bookTourPackage(WebDriver driver,String startDate,String endDate,String comment) 
	{
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		startDateEdt.sendKeys(startDate);
		endDateEdt.sendKeys(endDate);
		jsu.scrollDown();
		commentEdt.sendKeys(comment);
		bookBtn.click();		
	}
	
	/**
	 * This method is used to book a package with details from excel for locators of web elements and sending data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void bookTourPackage() throws EncryptedDocumentException, IOException
	{
		JavaUtility ju=new JavaUtility();
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		ExcelUtility eu=new ExcelUtility();
		HashMap<String, String> map = eu.getMultipleData("BookPackage");
		for(Entry<String, String> set:map.entrySet())
		{
			if(set.getKey().contains("Comment"))
			{
				jsu.scrollDown();
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+ju.getRandomNumber());
			}
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		}
		bookBtn.click();		
	}
	
	/**
	 * This method will return the status of booking
	 * @return
	 */
	public String confirmationStatus() 
	{
		String status=bookingConfirmation.getText();
		return status;
	}
}
