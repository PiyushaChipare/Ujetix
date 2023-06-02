package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaScriptUtility;
import com.GenericUtilities.WebDriverUtility;


public class ManageBookingsPage 
{
	WebDriver driver=null;

	public ManageBookingsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will confirm booking
	 * @param comment
	 * @return
	 */
	public void confirmBooking(String comment) 
	{
		WebElement confirmLnk = driver.findElement(By.xpath("//span[.='"+comment+"']/../..//td[9]//a[.='Confirm']"));
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		jsu.scrollTillElement(confirmLnk);
		WebDriverUtility wutil=new WebDriverUtility();
		confirmLnk.click();
		wutil.acceptAlert(driver);
	}
	
	/**
	 * This method will cancel booking
	 * @param comment
	 * @return
	 */
	public void cancelBooking(String comment) 
	{
		WebDriverUtility wutil=new WebDriverUtility();
		WebElement cancelLnk=driver.findElement(By.xpath("//span[.='"+comment+"']/../..//td[9]//a[.='Cancel']"));
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		jsu.scrollTillElement(cancelLnk);
		cancelLnk.click();
		wutil.acceptAlert(driver);
	}
	
	/**
	 * This method will return booking status
	 * @param comment
	 * @return
	 */
	public String getBookingStatus(String comment) 
	{
		String status = driver.findElement(By.xpath("//span[.='"+comment+"']/../..//td[8]//span")).getText();
		return status;
	}
	
}
