package com.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains methods related to WebDriver
 * @author Piyusha Chipare
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();		
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) 
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method till provide implicit wait for driver
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitWaitDuration));
	}
	
	/**
	 * This method will wait for entire page to load
	 * @param driver
	 */
	public void pageLoadWait(WebDriver driver) 
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}
	
	/**
	 * This method will wait till the given element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait till the given element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait till alert is visible
	 * @param driver
	 */
	public void waitForAlertPopup(WebDriver driver) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * This method will wait till expected title is present
	 * @param driver
	 * @param title
	 */
	public void waitForTitle(WebDriver driver,String title) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * This method will wait till url contains given partial url
	 * @param driver
	 * @param partialUrl
	 */
	public void waitForUrl(WebDriver driver,String partialUrl) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}
	
	/**
	 * This method selects element from dropdown for given index
	 * @param element
	 * @param index
	 */
	public void selectElementFromDropDown(WebElement element,int index) 
	{
		Select s=new Select(element);
		s.selectByIndex(index);		
	}
	
	/**
	 * This method selects element from dropdown for given value
	 * @param element
	 * @param value
	 */
	public void selectElementFromDropDown(WebElement element,String value) 
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This  method selects element from dropdown for given visibleText
	 * @param visibleText
	 * @param element
	 */
	public void selectElementFromDropDown(String visibleText,WebElement element) 
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will print all the options in dropdown
	 * @param element
	 */
	public void getDropdownOptions(WebElement element) 
	{
		Select s=new Select(element);
		List<WebElement> opt = s.getOptions();
		for(WebElement e: opt)
		{
			System.out.println(e.getText());
		}
	}
	
	/**
	 * This method us used to switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method us used to switch to frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method us used to switch to frame based on WebElement
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method us used to switch to main frame
	 * @param driver
	 */
	public void switchtoMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method us used to switch to immediate parent frame
	 * @param driver
	 */
	public void switchtoParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method is used to handle file upload popup
	 * @param element
	 * @param filePath
	 */
	public void fileUpload(WebElement element,String filePath)
	{
		element.sendKeys(filePath);
	}
	
	/**
	 * This method is used to accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to dissmis the alert
	 * @param driver
	 */
	public void dissmisAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to hover mouse over given element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to click on given element
	 * @param driver
	 * @param element
	 */
	public void click(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.click(element).perform();
	}
	
	/**
	 * This method is used to perform right click action on given element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();		
	}
	
	/**
	 * This method is used to perform double click action on given element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to take screenshot of view port area
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException 
	{
		JavaUtility jutil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenShots/"+screenShotName+jutil.getTimeForScreenShot()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
	/**
	 * This method is used to switch window to the given partial title
	 * @param driver
	 * @param title
	 */
	public void switchWindow(WebDriver driver,String partialTitle) 
	{
		Set<String> win = driver.getWindowHandles();
		for(String w:win)
		{
			driver.switchTo().window(w);
			if(driver.getTitle().contains(partialTitle))
			{
				break;
			}
		}
	}
	public void closeWindow(WebDriver driver,String partialUrl) 
	{
		Set<String> win = driver.getWindowHandles();
		for(String w:win)
		{
			driver.switchTo().window(w);
			if(driver.getCurrentUrl().contains(partialUrl))
			{
				driver.close();
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch window to the given partial url
	 * @param partialUrl
	 * @param driver
	 */
	public void switchWindow(String partialUrl,WebDriver driver) 
	{
		Set<String> win = driver.getWindowHandles();
		for(String w:win)
		{
			driver.switchTo().window(w);
			if(driver.getCurrentUrl().contains(partialUrl))
			{
				break;
			}
		}
	}
	
	/**
	 * This method is to scroll the webpage by given x y offset
	 * @param driver
	 * @param xOffset
	 * @param yOffset
	 */
	public void scrollBy(WebDriver driver,int xOffset,int yOffset )
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+xOffset+","+yOffset+")", "");
	}
	
	/**
	 * This method is used to scroll to given x y co-ordinates
	 * @param driver
	 * @param xOffset
	 * @param yOffset
	 */
	public void scrollTo(WebDriver driver,int xOffset,int yOffset )
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo("+xOffset+","+yOffset+")", "");
	}
}
