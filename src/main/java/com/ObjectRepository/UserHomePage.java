package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage 
{
	@FindBy(linkText = "My Profile") private WebElement myProfileLnk;
	
	@FindBy(linkText = "Change Password") private WebElement changePasswordLnk;
	
	@FindBy(linkText = "My Tour History") private WebElement myTourHistoryLnk;
	
	@FindBy(linkText = "Issue Tickets") private WebElement issueTicketsLnk;
	
	@FindBy(linkText = "/ Logout") private WebElement logoutLnk;
	
	@FindBy(linkText = "Tour Packages") private WebElement tourPackagesLnk;
	
	@FindBy(partialLinkText = "Write Us") private WebElement writeUsLnk;

	public UserHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyProfileLnk() {
		return myProfileLnk;
	}

	public WebElement getChangePasswordLnk() {
		return changePasswordLnk;
	}

	public WebElement getMyTourHistoryLnk() {
		return myTourHistoryLnk;
	}

	public WebElement getIssueTicketsLnk() {
		return issueTicketsLnk;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}

	public WebElement getTourPackagesLnk() {
		return tourPackagesLnk;
	}

	public WebElement getWriteUsLnk() {
		return writeUsLnk;
	}
	
	//Business Library
	
	/**
	 * This method will log out the user
	 */
	public void userLogout() 
	{
		logoutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
