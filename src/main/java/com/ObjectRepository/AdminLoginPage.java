package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaScriptUtility;

public class AdminLoginPage 
{
	WebDriver driver=null;
	@FindBy(name = "username") private WebElement usernameEdt;
	
	@FindBy(name = "password") private WebElement passwordEdt;
	
	@FindBy(name = "login") private WebElement loginBtn;
	
	@FindBy(xpath = "//a[.='Back to home']") private WebElement backToHome;
	
	public AdminLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	/**
	 * This method will log in as admin
	 * @param username
	 * @param password
	 */
	public void adminLogin(String username,String password)
	{
		//Admin Login
		WelcomePage wp=new WelcomePage(driver);
		wp.getAdminLoginLnk().click();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	/**
	 * This method will navigate to Welcome page
	 */
	public void adminLogout()
	{
		JavaScriptUtility jsutil=new JavaScriptUtility(driver);
		jsutil.scrollUp();
		//Admin Logout
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.goToAdminLogin();
		backToHome.click();
	}
	
	/**
	 * This method will return true if login is successful
	 * And False is login is unsuccessful
	 * @param driver
	 * @return
	 */
	public boolean adminLoginSuccessFul(WebDriver driver)
	{
		String adminHome = driver.getCurrentUrl();
		if(adminHome.contains("dashboard"))
			return true;
		else
			return false;
	}
}
