package com.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener
{
	public void onTestStart(ITestResult result) 
	{
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String testName = result.getMethod().getMethodName();
		System.out.println("-----------"+testName+" -->Test Failed-----------");
		
		WebDriverUtility wu=new WebDriverUtility();
		try {
			wu.takeScreenShot(BaseClass.sdriver, testName);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context) 
	{
		
	}	
}
