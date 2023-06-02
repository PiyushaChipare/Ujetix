package com.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.JavaScriptUtility;

public class MyTourHistoryPage 
{
	WebDriver driver=null;

	public MyTourHistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will check the status of booking
	 * @param comment
	 * @return
	 */
	public String bookingStatus(String comment) 
	{
		String bookingStatus = driver.findElement(By.xpath("//td[.='"+comment+"']/..//td[7]")).getText();
		return bookingStatus;
	}
	
	/**
	 * This method will cancel the booking 
	 * @param comment
	 * @return
	 */
	public boolean cancelBooking(String comment) 
	{
		try 
		{
			WebElement cancelLnk = driver.findElement(By.xpath("//td[.='"+comment+"']/../td[9]/a"));
			JavaScriptUtility jsu=new JavaScriptUtility(driver);
			jsu.scrollTillElement(cancelLnk);
			cancelLnk.click();
			WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
			w.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
		
	}
	
	//for cancel the booking
	//   //td[.='aaa']/../td[9]/a
	
	//
}
