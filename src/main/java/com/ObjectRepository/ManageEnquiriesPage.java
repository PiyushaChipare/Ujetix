package com.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.JavaScriptUtility;
import com.GenericUtilities.WebDriverUtility;

public class ManageEnquiriesPage 
{
	WebDriver driver=null;

	public ManageEnquiriesPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	/**
	 * This method will read the pending enquiry
	 * @param SUBJECT
	 */
	public void readPendingEnquiry(String SUBJECT) 
	{
		WebElement pending = driver.findElement(By.xpath("//span[.='"+SUBJECT+"']/../..//a"));
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		jsu.scrollTillElement(pending);
		pending.click();
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.alertIsPresent());
		wutil.acceptAlert(driver);	
	}
	

}
