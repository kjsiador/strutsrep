package com.struts.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection dbCon() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "admin");
			System.out.println("Connection successful");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
		
}
