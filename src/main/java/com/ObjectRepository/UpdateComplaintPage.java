package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class UpdateComplaintPage 
{
	WebDriver driver;
	@FindBy(name = "remark") private WebElement remarkEdt;
	
	@FindBy(name = "submit2") private WebElement updateBtn;

	public WebElement getRemarkEdt() {
		return remarkEdt;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public UpdateComplaintPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to update remark by admin in update complaint child pop up window 
	 * @param driver
	 * @param remark
	 * @param partialUrlToClose
	 * @param partialTitleToMain
	 */
	public void updateRemark(WebDriver driver,String remark,String partialUrlToClose,String partialTitleToMain)
	{
		WebDriverUtility wu=new WebDriverUtility();
		wu.switchWindow(driver, partialUrlToClose);
		remarkEdt.sendKeys(remark);
		updateBtn.click();
		wu.closeWindow(driver, partialUrlToClose);
		wu.switchWindow(driver, partialTitleToMain);
		wu.scrollTo(driver, 0, 0);
	}
}
