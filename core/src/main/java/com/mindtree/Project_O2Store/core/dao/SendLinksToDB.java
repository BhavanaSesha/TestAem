package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class SendLinksToDB {
	private static String URL="jdbc:mysql://localhost:3306/o2store2";
	private static String USERNAME="root";
	private static String PASSWORD="Amalapuram@9";

	public String setDataToDb(String link1,double plantId)
    {
		String message="";
		int n=0;
		Connection con;
		Statement st;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st=con.createStatement();
			String sql= "UPDATE plants SET pdplink ='"+link1+"' WHERE plant_id="+plantId;
			n=st.executeUpdate(sql);
			System.out.println(n+" rows effected");
		}catch(Exception e) {
			message=e.getMessage();
		}
		return message;
	}
}
