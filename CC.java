package com.stmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CC 
{
	public static Connection conn() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanager","root","root");
		return con;
	}
}
