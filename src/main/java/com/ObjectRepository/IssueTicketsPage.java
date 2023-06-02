package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IssueTicketsPage 
{
	WebDriver driver=null;

	public IssueTicketsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will fetch the admin remarks from user login
	 * @param description
	 * @return
	 */
	public String adminRemarkText(String description)
	{
		String adminRemarks = driver.findElement(By.xpath("//td[.='"+description+"']/following-sibling::td[1]")).getText();	
		return adminRemarks;
	}

}
