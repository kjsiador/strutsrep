package com.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.struts.form.UserForm;

public class UsersDao {
	
	public List<UserForm> viewUsers() throws Exception {
		Connection conn = DBConnection.dbCon();
		System.out.println("Connection: " + conn);
		UserForm user = new UserForm();
		List<UserForm> list = new ArrayList<UserForm>();
		ResultSet rs = null;
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM USERS ORDER BY USERID";
			rs = statement.executeQuery(query);
			while(rs.next()) {
				user.setUserid(rs.getInt("USERID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setFirstname(rs.getString("FIRSTNAME"));
				user.setLastname(rs.getString("LASTNAME"));
				user.setEmail(rs.getString("EMAIL"));
				list.add(user);
				user = new UserForm();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int saveUser(UserForm user) throws Exception {
		int r = 0;
		Connection conn = DBConnection.dbCon();
		System.out.println("Connection: " + conn);
		try {
			PreparedStatement ps = null;
			ps = conn.prepareStatement(
					"INSERT INTO USERS (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL) VALUES(?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5, user.getEmail());
			r = ps.executeUpdate();

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
		return r;
	}
}
