package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnecterLogin {
	
	

	public static boolean Connect(String username, String password, boolean usertype)  {
		boolean status = false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletass", "username", "password");
			System.out.println("Connected successfully");
			
			PreparedStatement pre = connection.prepareStatement(" select * from employe where username =? and password =? and usertype=?");
			
			pre.setString(1, username);
			pre.setString(2, password);
			pre.setBoolean(3, usertype);
			
			ResultSet result = pre.executeQuery();
		
			status = result.next();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;

 }
}

