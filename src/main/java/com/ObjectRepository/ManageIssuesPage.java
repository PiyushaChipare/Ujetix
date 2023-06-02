package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaScriptUtility;


public class ManageIssuesPage 
{
	WebDriver driver=null;
	public ManageIssuesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will click on View button for given description
	 * @param description
	 */
	public void clickOnView(String description) 
	{
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		WebElement viewLnk = driver.findElement(By.xpath("//span[.='"+description+"']/../following-sibling::td[2]//a[.='View ']"));
		jsu.scrollTillElement(viewLnk);
		viewLnk.click();
	}
	
	

}
