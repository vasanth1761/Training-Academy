package com.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class tableConnection {
	public static Connection getConnection() throws ClassNotFoundException,SQLException
	 {
		Class.forName("com.mysql.cj.jdbc.Driver");

		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingacademy", "root", "Vasanth@1761");
      return con ;
	 }
}


