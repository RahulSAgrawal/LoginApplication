package com.dynamicQuery;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aartek.login.DBConnection;



@WebServlet("/ValidationLogic")
public class ValidationLogic extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	response.setContentType("text/html");
	PrintWriter printWriter =response.getWriter();
	
	String name=request.getParameter("name");
	String empId=request.getParameter("empId");
	String contNo=request.getParameter("contnNo");
	String address=request.getParameter("address");
	
	Connection con=DBConnection.getconnections();
	PreparedStatement ps;
	
	StringBuilder sqlBuilder = new StringBuilder();
	String sqlquery;

	
	  try
	  {
	   if(name!=null)
	   {
	    
	  sqlBuilder.append("SELECT *")
			   .append("FROM employee")
			   .append(" WHERE name  = ?");
	   sqlquery = sqlBuilder.toString();
	   
	   ps=con.prepareStatement(sqlquery);
	   ps.setString(1, name);
	   ResultSet rs = ps.executeQuery();
	   while(rs.next())
	   {
		   
	    String n = rs.getString(1);
	    String p = rs.getString(2);
	    
	    System.out.println(" name is =  "+n);
	    printWriter.println("name is  =  " +n + " and EmpID is  = "+p );
	   }
	   
	   }
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }
	  }
	  }
