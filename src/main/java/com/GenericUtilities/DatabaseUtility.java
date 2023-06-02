package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	public Connection connect=null;
	
	/**
	 * This method is used to get connection with database
	 * @param databaseName
	 * @throws SQLException
	 */
	public void getConnection(String databaseName) throws SQLException 
	{
		Driver drv=new Driver();
		DriverManager.registerDriver(drv);
		connect = DriverManager.getConnection(IConstants.mySqlUrl+databaseName,IConstants.mySqlUsername,IConstants.mySqlPassword);
	}
	
	/**
	 * This method will close the connection with database
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException 
	{
		connect.close();
	}	
}
