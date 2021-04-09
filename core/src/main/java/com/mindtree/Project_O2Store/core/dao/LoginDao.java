package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.Project_O2Store.core.entity.Login;


public class LoginDao {

	public boolean validate(Login login) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/o2store_project", "root",
				"Bhavana@1");


		    Statement st = connection.createStatement();) {
			ResultSet rs = st.executeQuery("select email,password from login_Registration");
			String email = "";
		    String password = "";
			while (rs.next()) {
				email = rs.getString("email");
				password = rs.getString("password");
				if (email.equals(login.getEmail()) && password.equals(login.getPassword())) {
					status = true;
					return status;
				}

			}

		} catch (SQLException e) {
			System.out.println("error");
		}
		return status;
	}
}
