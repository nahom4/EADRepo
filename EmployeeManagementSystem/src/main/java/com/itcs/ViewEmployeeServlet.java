package com.itcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/EmployeeDb";
			String username = "root"; 
			String password = "root";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,
			username, password);
			
			PrintWriter pw = res.getWriter();
			String query = "select * from employee";
			PreparedStatement pt = conn.prepareStatement(query);
			ResultSet rs = pt.executeQuery();
			
			res.setContentType("text/html");
			pw.print("<html>");
			pw.print("<head>");
			pw.print("<link rel = \"stylesheet\" href =\"CSS/bootstrap.css\">");
			
			pw.print("</head>");
			pw.print("<body>");
			pw.print("<h2>Employee Table</h2>");
			pw.print("<table>");
			pw.print("<tr>");
			pw.print("<td>" + "Name" + "</td>");
			pw.print("<td>" + "Designation" + "</td>");
			pw.print("<td>" + "Salary" + "</td>");
			pw.print("</tr>");
			while (rs.next()) {
				
				pw.print("<tr>");
				pw.print("<td>" + rs.getString(2) + "</td>");
				pw.print("<td>" + rs.getString(3) + "</td>");
				pw.print("<td>" + rs.getFloat(4) + "</td>");
				pw.println("<td><a href ='edit?id=" + rs.getInt(1) + "'>edit</a></td>");
				pw.println("<td><a href ='delete?id=" + rs.getInt(1) +"'>delete</a></td>");
						pw.println("</tr>");
				pw.print("</tr>");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
