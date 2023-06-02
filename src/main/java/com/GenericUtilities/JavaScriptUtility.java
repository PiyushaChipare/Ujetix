package com.GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility 
{
	JavascriptExecutor js;

	public JavaScriptUtility(WebDriver driver) 
	{
		js=(JavascriptExecutor) driver;
	}
	
	/**
	 * This method will scroll to top of webpage
	 */
	public void scrollUp() 
	{
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)", "");
	}
	
	/**
	 * This method will scroll till given element
	 * @param element
	 */
	public void scrollTillElement(WebElement element) 
	{
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	/**
	 * This method will scroll to bottom of webpage
	 */
	public void scrollDown() 
	{
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	
	/**
	 * This method is used to get given url
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	
	/**
	 * This method is used to send data in given WebElement
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element,String data) 
	{
		js.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	
	/**
	 * This method is used to click on given element
	 * @param element
	 */
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * This method is used for clicking on element by giving its id
	 * @param elementId
	 */
	public void clickElementById(String elementId) 
	{
		js.executeScript("document.getElementById('elementId').click()");
	}
	
	/**
	 * This method is used to get text of element given
	 * @param element
	 * @return String
	 */
	public String getTheText(WebElement element)
	{
		String textFieldValue = (String)js.executeScript("return arguments[0].value;", element);
		return textFieldValue;
	}
	
	/**
	 * This method is used to get url of current WebPage
	 * @return String
	 */
	public String getUrlOfCurrentPage() 
	{
		String url=(String)js.executeScript("return window.location.href");
		return url;
	}
	
	/**
	 * This method is used to get title of current WebPage
	 * @return String
	 */
	public String getTitleOfCurrentPage() 
	{
		String title = (String)js.executeScript("return document.title");
		return title;
	}
}
