package com.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.WebDriverUtility;

public class WriteUsPage {

		@FindBy(name = "issue") private WebElement issueDropdown;
		
		@FindBy (name = "description") private WebElement descriptionEdt;
		
		@FindBy (xpath = "//button[.='Submit']") private WebElement submitBtn;

		public WriteUsPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getIssueDropdown() {
			return issueDropdown;
		}
		
		public WebElement getDescriptionEdt() {
			return descriptionEdt;
		}

		public WebElement getSubmitBtn() {
			return submitBtn;
		}

		//Business library
		/**
		 * This method is used to Create issue
		 * @param driver
		 * @param index
		 * @param description
		 */
		public void createIssue(WebDriver driver,int index,String description)
		{
					WebDriverUtility wutil=new WebDriverUtility();
					WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
					w.until(ExpectedConditions.elementToBeClickable(issueDropdown));
					wutil.selectElementFromDropDown(issueDropdown, index);
					descriptionEdt.sendKeys(description);
					submitBtn.click();
		}
		
		/**
		 * This method is used to verify if issue is created or not
		 * @param driver
		 * @return
		 */
		public boolean issueCreatedOrNot(WebDriver driver)
		{
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains("thankyou"))
			return true;
			else
			return false;
		}
	}
