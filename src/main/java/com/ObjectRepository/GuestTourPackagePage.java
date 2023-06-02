package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GuestTourPackagePage 
{
	WebDriver driver=null;

	public GuestTourPackagePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will check if given package is present or not
	 * @param packageName
	 * @return
	 */
	public boolean packagePresentOrNot(String packageName)
	{
		try 
		{
			driver.findElement(By.xpath("//h4[contains(.,'"+packageName+"')]"));
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}		
	}
}
