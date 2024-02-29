package com.abc.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public Connection getDBConn() throws ClassNotFoundException,SQLException
	{
		String url="jdbc:mysql://localhost:3306/students";
		String username="root";
		String password="root";
		Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return con;
	}
}