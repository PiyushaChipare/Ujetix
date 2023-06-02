package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaScriptUtility;


public class PackageListPage 
{
	WebDriver driver=null;
	public  PackageListPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Business Library
	/**
	 * This method will click on details button of given package name
	 * @param packageName
	 */
	public void clickOnDetailsButton(String packageName) 
	{
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		WebElement details = driver.findElement(By.xpath("//h4[contains(.,'"+packageName+"')]/../..//a[.='Details']"));
		jsu.scrollTillElement(details);
		details.click();
	}
	
	/**
	 * This method will check if given package name is present in package list page or not
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
