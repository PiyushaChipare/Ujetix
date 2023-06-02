package com.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class contains all methods related to all java classes
 * @author Piyusha Chipare
 *
 */
public class JavaUtility 
{
	/**
	 * This method will return a random number
	 * @return
	 */
	public int getRandomNumber() 
	{
		Random r=new Random();
		return r.nextInt(2000);
	}
	
	/**
	 * This method till return current system date
	 * @return
	 */
	public String getCurrentSystemDate() 
	{
		Date d=new Date();
		return d.toString();
	}
	
	/**
	 * This method return date in mm-dd-yyyy format
	 * @return
	 */
	public String getSystemDateInFormat() 
	{
		Date d=new Date();
		String[] date = d.toString().split(" ");
		int month=d.getMonth();
		String cDate=date[2];
		String year=date[5];
		
		return month+"-"+cDate+"-"+year;		
	}
	public String getTimeForScreenShot() 
	{
		Date d=new Date();
		String[] date = d.toString().split(" ");
		String cDate=date[2];
		String year=date[5];
		String time=date[3].replace(':', '-');
		String result = cDate+date[1]+year+"_"+time;
		return result;
	}
}
