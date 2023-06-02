package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the web elements and business logics related to welcome page
 * @author Piyusha Chipare
 *
 */
public class WelcomePage 
{
	@FindBy(partialLinkText = "Sign In") private WebElement signInLnk;
	
	@FindBy(linkText = "Sign Up") private WebElement signUpLnk;
	
	@FindBy(linkText = "Admin Login") private WebElement adminLoginLnk;
	
	@FindBy(partialLinkText = "Enquiry") private WebElement  enquiryLnk;
	
	@FindBy(linkText = "Tour Packages") private WebElement tourPackagesLnk;
	
	@FindBy(linkText = "View More Packages") private WebElement viewMorePackagesLnk;
	
	@FindBy(linkText = "About") private WebElement aboutLnk;
	
	@FindBy(linkText = "Privacy Policy") private WebElement privacyPolicyLnk;
	
	@FindBy(linkText = "Terms of Use") private WebElement termsOfUseLnk;
	
	@FindBy(linkText = "Contact Us") private WebElement contactUsLnk;
	
	@FindBy(name = "fname") private WebElement suFullNameEdt;
	
	@FindBy(name = "mobilenumber") private WebElement suMobileNumberEdt;
	
	@FindBy(xpath = "//h3[.='Create your account ']/following-sibling::input[@id='email']") private WebElement suEmailEdt;
	
	@FindBy(xpath = "//h3[.='Create your account ']/following-sibling::input[@name='password']") private WebElement suPasswordEdt;
	
	@FindBy(xpath = "//input[@value='CREATE ACCOUNT']") private WebElement suCreateAccountBtn;
	
	@FindBy(xpath = "//h3[.='Signin with your account ']/following-sibling::input[@id='email']") private WebElement siUsernameEdt;
	
	@FindBy(xpath = "//h3[.='Signin with your account ']/following-sibling::input[@id='password']") private WebElement siPasswordEdt;
	
	@FindBy(name = "signin") private WebElement siSignInBtn;
		
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSignInLnk() {
		return signInLnk;
	}



	public WebElement getSignUpLnk() {
		return signUpLnk;
	}



	public WebElement getAdminLoginLnk() {
		return adminLoginLnk;
	}



	public WebElement getEnquiryLnk() {
		return enquiryLnk;
	}



	public WebElement getTourPackagesLnk() {
		return tourPackagesLnk;
	}



	public WebElement getViewMorePackagesLnk() {
		return viewMorePackagesLnk;
	}



	public WebElement getAboutLnk() {
		return aboutLnk;
	}



	public WebElement getPrivacyPolicyLnk() {
		return privacyPolicyLnk;
	}



	public WebElement getTermsOfUseLnk() {
		return termsOfUseLnk;
	}



	public WebElement getContactUsLnk() {
		return contactUsLnk;
	}



	public WebElement getSuFullNameEdt() {
		return suFullNameEdt;
	}



	public WebElement getSuMobileNumberEdt() {
		return suMobileNumberEdt;
	}



	public WebElement getSuEmailEdt() {
		return suEmailEdt;
	}



	public WebElement getSuPasswordEdt() {
		return suPasswordEdt;
	}



	public WebElement getSuCreateAccountBtn() {
		return suCreateAccountBtn;
	}



	public WebElement getSiUsernameEdt() {
		return siUsernameEdt;
	}



	public WebElement getSiPasswordEdt() {
		return siPasswordEdt;
	}



	public WebElement getSiSignInBtn() {
		return siSignInBtn;
	}

	//Business Logics
	
	//SignUp as user
		
	/**
	 * This method is used to create user
	 * @param fullName
	 * @param mobileNumber
	 * @param emailId
	 * @param password
	 * @throws InterruptedException
	 */
	public void signUpUser(String fullName,String mobileNumber,String emailId,String password) throws InterruptedException 
	{
		signUpLnk.click();
		suFullNameEdt.sendKeys(fullName);
		suMobileNumberEdt.sendKeys(mobileNumber);
		suEmailEdt.sendKeys(emailId);
		suPasswordEdt.sendKeys(password);
		suCreateAccountBtn.click();
		System.out.println("Created Successfully!!!");
	}
	
	/**
	 * This method is used to sign in as user
	 * @param username
	 * @param password
	 * @throws InterruptedException
	 */
	public void signInUser(String username,String password) throws InterruptedException 
	{
		signInLnk.click();
		siUsernameEdt.sendKeys(username);
		siPasswordEdt.sendKeys(password);
		siSignInBtn.click();
	}
	
	
}
