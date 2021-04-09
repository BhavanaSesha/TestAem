package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.Project_O2Store.core.entity.ForgetPassword;


public class ForgetPasswordDao {
	public boolean forgetPassword(ForgetPassword forget) throws ClassNotFoundException {
		boolean status = false;
		boolean statusAssigned = false;
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/o2store2", "root",
				"Amalapuram@9"); 
			Statement st = connection.createStatement();) {
			ResultSet rs = st.executeQuery("select email from login_Registration");
			String email2 = "";
			String newpassword2 = "";
			while (rs.next()) {
				email2 = rs.getString(1);
				
				if (email2.equals(forget.getEmail())) {
					 Statement stmt = connection.createStatement();
				      String sql = "UPDATE login_Registration SET password =  '"+forget.getNewpassword()+"' WHERE email='"+email2+"'";
				      stmt.executeUpdate(sql);
					status = true;
					statusAssigned = true;
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		if(statusAssigned) 
			return status;
		else
			return false;
		
		
	}
}
