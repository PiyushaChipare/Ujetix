package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepository.AdminLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public String ADMINUSERNAME;
	public String ADMINPASSWORD;
	public String USERUSERNAME;
	public String USERPASSWORD;
	
	public JavaUtility jutil=new JavaUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public FileUtility putil=new FileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	DatabaseUtility dbutil;	
	
	@BeforeSuite (groups = {"smokeTest", "integrationTest"}, alwaysRun = true)
	public void config_BS() throws SQLException, InterruptedException
	{
		dbutil=new DatabaseUtility();
		dbutil.getConnection("sdet48");
		Thread.sleep(30000);
	}
	
	@Parameters("BROWSER")
	@BeforeClass (groups = {"smokeTest", "integrationTest"})
	public void config_BC(/*String BROWSER*/ ) throws IOException
	{
		String BROWSER =putil.getPropertyData("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(opt);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		wutil.maximizeWindow(driver);
		wutil.implicitWait(driver);
		sdriver=driver;
	}

	@BeforeMethod(groups = {"smokeTest", "integrationTest"})
	public void config_BM() throws IOException
	{
		String URL =putil.getPropertyData("url");
		ADMINUSERNAME =putil.getPropertyData("adminusername");
		ADMINPASSWORD = putil.getPropertyData("adminpassword");
		USERUSERNAME =putil.getPropertyData("userusername");
		USERPASSWORD =putil.getPropertyData("userpassword");
		
		//Open Application
		driver.get(URL);
		
		//Admin Login
	
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogin(ADMINUSERNAME, ADMINPASSWORD);
	}
	
	@AfterMethod(groups = {"smokeTest", "integrationTest"})
	public void config_AM()
	{
		JavaScriptUtility jsutil=new JavaScriptUtility(driver);
		jsutil.scrollUp();
		//Admin Logout
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogout();
	}
	
	@AfterClass(groups = {"smokeTest", "integrationTest"})
	public void config_AC()
	{
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest", "integrationTest"})
	public void config_AS() throws SQLException 
	{
		dbutil.closeConnection();
	}
}
