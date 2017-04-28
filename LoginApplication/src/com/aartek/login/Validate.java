package com.aartek.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {

	public  static boolean Check(String email,String pass)
	{
		boolean st =false;
		try{  
		Connection con=DBConnection.getconnections();
		
//		System.out.println(con);
		PreparedStatement ps =con.prepareStatement
                 ("select * from login where email=? and password=?");
		 ps.setString(1, email);
		 ps.setString(2, pass);
		 ResultSet rs =ps.executeQuery();
		 st = rs.next();
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		return st;
		} 
	}