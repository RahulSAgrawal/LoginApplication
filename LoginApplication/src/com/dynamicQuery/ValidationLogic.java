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
	ResultSet rs ;
	StringBuilder sqlBuilder = new StringBuilder();
	String sqlquery;

	
	  try
	  {
	   /*
	    if(name!=null)
	   {
	    
	  sqlBuilder.append("SELECT *")
			   .append("FROM employee")
			   .append(" WHERE name  = ?");
	   sqlquery = sqlBuilder.toString();
	   
	   ps=con.prepareStatement(sqlquery);
	   ps.setString(1, name);
	   rs = ps.executeQuery();
	   while(rs.next())
	   {
		   System.out.println("Print");
	    String n = rs.getString(1);
	    String p = rs.getString(2);
	    
	    System.out.println(" name is =  "+n);
	    printWriter.println("name is  =  " +n + "\n and EmpID is  = "+p );
	   }
	   }
	   */
//		 /* 
		   if(name!= null && empId!= null)
		   {
		    
		    System.out.println("in  try block");
		    sqlBuilder.append("SELECT *")
		    .append("FROM employee")
		    .append(" WHERE name  = ?")
		    .append("AND")
		    .append(" empid  = ?");
		    
		    System.out.println("after builder try block");
		    sqlquery = sqlBuilder.toString();
		    ps = con.prepareStatement(sqlquery);
		    System.out.println("after after sqlquery block");
		    ps.setString(1, name);
		    ps.setString(2, empId);
		    rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	name = rs.getString(1);
		    	empId = rs.getString(2);
		      System.out.println(" name is =  "+name);
		      printWriter.println("Name is  =  " +name + "\n and EmpID is  = "+empId );
		    }
		   }
//		  */
		  /*
		  if(name!= null && empId!=null  && contNo!=null && address!=null){
			  sqlBuilder.append("Select * ")
			  .append("from employee")
			  .append("where name = ?")
			  .append(" AND ")
			  .append("empid = ?")
			  .append(" AND ")
			  .append("contno = ? ")
			  .append(" AND ")
			  .append("address = ?");
	 sqlquery = sqlBuilder.toString();
	 ps=con.prepareStatement(sqlquery);
	 ps.setString(1, name);
	 ps.setString(2, empId);
	 ps.setString(3, contNo);
	 ps.setString(4, address);
	 rs=ps.executeQuery();
	while(rs.next()){
		name=rs.getString(1);
		empId=rs.getString(2);
		contNo=rs.getString(3);
		address=rs.getString(4);
		System.out.println("Result");
		printWriter.println("Result");
		printWriter.println("Name\t "+name+"empID\t"+empId+"Contact No"+contNo+"Address"+address);
			
	}		 
		  }*/
		   
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }
	  }
	  }