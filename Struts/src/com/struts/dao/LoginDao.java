package com.struts.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.struts.form.LoginForm;

public class LoginDao {

	public boolean verifyLogin(LoginForm login) throws Exception {
		boolean flag = false;
		Connection conn = DBConnection.dbCon();
		System.out.println("Connection: " + conn);
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT COUNT(*) FROM USERS WHERE USERNAME ='" + login.getUsername() + "' AND PASSWORD = '"
					+ login.getPassword() + "'";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				flag = (rs.getInt(1) > 0) ? true : false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
