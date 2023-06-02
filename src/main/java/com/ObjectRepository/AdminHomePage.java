package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;


public class AdminHomePage 
{
	@FindBy(xpath = "//span[.=' Tour Packages']") private WebElement tourPackageLnk;
	
	@FindBy(xpath = "//a[.='Create']") private WebElement createTourPackageLnk;
	
	@FindBy(xpath = "//a[.='Manage']") private WebElement manageTourPackageLnk;
	
	@FindBy(xpath = "//span[.='Manage Users']") private WebElement manageUserLnk;
	
	@FindBy(xpath = "//span[.='Manage Booking']") private WebElement manageBookingLnk;
	
	@FindBy(xpath = "//span[.='Manage Issues']")private WebElement manageIssueLnk;
	
	@FindBy(xpath = "//span[.='Manage Enquiries']")private WebElement manageEnquiriesLnk;
	
	@FindBy(xpath = "//span[.='Manage Pages']") private WebElement managePagesLnk;
	
	@FindBy(xpath = "//span[.='Dashboard']")private WebElement dashboardLnk;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")private WebElement administratorDropdown;
	
	@FindBy(xpath = "//a[.=' Profile']")private WebElement profileBtn;

	@FindBy(xpath = "//a[.=' Logout']")private WebElement logoutBtn;

	public AdminHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTourPackageLnk() {
		return tourPackageLnk;
	}
	
	public WebElement getCreateTourPackageLnk() {
		return createTourPackageLnk;
	}
	
	public WebElement getManageTourPackageLnk() {
		return manageTourPackageLnk;
	}

	public WebElement getManageUserLnk() {
		return manageUserLnk;
	}

	public WebElement getManageBookingLnk() {
		return manageBookingLnk;
	}

	public WebElement getManageIssueLnk() {
		return manageIssueLnk;
	}

	public WebElement getManageEnquiriesLnk() {
		return manageEnquiriesLnk;
	}

	public WebElement getManagePagesLnk() {
		return managePagesLnk;
	}

	public WebElement getDashboardLnk() {
		return dashboardLnk;
	}

	public WebElement getAdministratorDropdown() {
		return administratorDropdown;
	}

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	//Business Library
	/**
	 * This method will navigate to Create Package Page
	 */
	public void goToCreatePackagePage(WebDriver driver,WebDriverUtility wutil) 
	{
		tourPackageLnk.click();
		wutil.mouseHoverOnElement(driver, createTourPackageLnk);
		wutil.click(driver, createTourPackageLnk);
		
	}
	
	/**
	 * This method will navigate to Manage Package Page
	 */
	public void goToManagePackagePage(WebDriver driver,WebDriverUtility wutil) 
	{
		tourPackageLnk.click();
		wutil.mouseHoverOnElement(driver, manageTourPackageLnk);
		wutil.click(driver, manageTourPackageLnk);
	}
	
	/**
	 * This method will log out the admin and navigate to admin login page
	 */
	public void goToAdminLogin()
	{
		administratorDropdown.click();
		logoutBtn.click();
	}
	
	
	
}
