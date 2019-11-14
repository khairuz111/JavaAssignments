package com.zaloni.webApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider implements MyProvider
{
	static Connection con=null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
		
		return con;
	}

}
