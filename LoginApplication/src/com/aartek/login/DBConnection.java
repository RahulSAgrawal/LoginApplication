package com.aartek.login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
 public static	Connection con;
	static {
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");  
		System.out.println("Connection"+con);
		}catch(Exception e)
		{
			System.out.println(e);}  
		}  
		public static Connection getconnections(){
		System.out.println("Con"+con);	 
			return con;
			 }
}