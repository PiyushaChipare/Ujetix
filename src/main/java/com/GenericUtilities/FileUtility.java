package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains method to read data from property files
 * @author Piyusha Chipare
 *
 */
public class FileUtility 
{
	/**
	 * This method will fetch data from property file for given key 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException 
	{
		FileInputStream fis=new FileInputStream(IConstants.propertyPath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;		
	}
}
