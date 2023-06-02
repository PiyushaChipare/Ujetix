package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaScriptUtility;


public class EnquiryPage 
{
	WebDriver driver=null;

	@FindBy(id = "fname") private WebElement fullNameEdt;
	
	@FindBy(id = "email") private WebElement emailEdt;
	
	@FindBy(id = "mobileno") private WebElement mobileNumberEdt;
	
	@FindBy(id = "subject") private WebElement subjectEdt;
	
	@FindBy(id = "description") private WebElement descriptionEdt;
	
	@FindBy(name = "submit1") private WebElement submitBtn;
	
	@FindBy (xpath = "//div[@class='succWrap']/strong") private WebElement confirmation;
	
	public EnquiryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullNameEdt() {
		return fullNameEdt;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getMobileNumberEdt() {
		return mobileNumberEdt;
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getConfirmation() {
		return confirmation;
	}

	//Business Library
	/**
	 * This method will create an enquiry
	 * @param fullName
	 * @param email
	 * @param mobileNumber
	 * @param subject
	 * @param description
	 */
	public void createEnquiry(String fullName,String email,String mobileNumber,String subject,String description)
	{
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
		fullNameEdt.sendKeys(fullName);
		emailEdt.sendKeys(email);
		mobileNumberEdt.sendKeys(mobileNumber);
		subjectEdt.sendKeys(subject);
		jsu.scrollDown();
		descriptionEdt.sendKeys(description);
		submitBtn.click();
	}
	
	/**
	 * This method will check if enquiry is created or not
	 * @param SUCCESS
	 * @return
	 */
	public boolean enquiryCreatedOrNot(String SUCCESS)
	{
		String status = confirmation.getText();
		if(status.equalsIgnoreCase(SUCCESS))
			return true;
		else
			return false;
	}	
}
