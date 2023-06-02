package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfileUserPage 
{
	@FindBy(id = "name") private WebElement nameEdt;
	
	@FindBy(id = "mobileno") private WebElement mobileNumberEdt;
	
	@FindBy( xpath = "//button[.='Updtae']") private WebElement updateBtn;

	public MyProfileUserPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business library
	
	/**
	 * This method will update the name of user
	 * @param name
	 */
	public void updateName(String name)
	{
		nameEdt.clear();
		nameEdt.sendKeys(name);
		updateBtn.click();
	}
	
	/**
	 * This method will update the mobile number of user
	 * @param mobileNumber
	 */
	public void updateMobileNumber(String mobileNumber)
	{
		mobileNumberEdt.clear();
		mobileNumberEdt.sendKeys(mobileNumber);
		updateBtn.click();
	}
	
	/**
	 * This method will update the name and mobile number of user
	 * @param name
	 * @param mobileNumber
	 */
	public void updateNameAndMobileNumber(String name,String mobileNumber) 
	{
		nameEdt.clear();
		nameEdt.sendKeys(name);
		mobileNumberEdt.clear();
		mobileNumberEdt.sendKeys(mobileNumber);
		updateBtn.click();
	}
	
	

}
