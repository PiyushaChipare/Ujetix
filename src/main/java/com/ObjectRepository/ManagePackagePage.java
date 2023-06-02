package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaScriptUtility;


public class ManagePackagePage 
{
	WebDriver driver=null;

	public ManagePackagePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will click on View Details button of given package
	 * @param packageName
	 */
	public void clickOnViewDetails(String packageName)
	{
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		WebElement viewDetails = driver.findElement(By.xpath("//span[.='"+packageName+"']/../..//a"));
		jsu.scrollTillElement(viewDetails);
		viewDetails.click();		
	}
	

}
