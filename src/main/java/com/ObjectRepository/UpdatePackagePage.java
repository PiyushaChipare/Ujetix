package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdatePackagePage 
{
	WebDriver driver=null;
	
	@FindBy (linkText = "Change Image") private WebElement changeImageLnk;
	
	@FindBy (xpath = "//button[.='Update']") private WebElement updateBtn;

	public UpdatePackagePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void udpatePackage()
	{
		
	}
	
	

}
