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

@WebServlet("/editurl")
public class EditEmployeeServlet extends HttpServlet {
	
protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/EmployeeDb";
			String username = "root"; 
			String password = "root";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,
			username, password);
			
			String name = req.getParameter("name");
			String designation = req.getParameter("designation");
			float salary = Float.parseFloat(req.getParameter("salary"));
			PrintWriter pw = res.getWriter();
		
			String query = "UPDATE employee  SET name = ?, designation = ?, sallary = ? WHERE id = ?";
			PreparedStatement pt = conn.prepareStatement(query);
			int id = Integer.parseInt(req.getParameter("id"));
			pt.setString(1, name);
			pt.setString(2, designation);
			
			pt.setFloat(3, salary);
			pt.setInt(4, id);
			int val = pt.executeUpdate();
			if (val == 1) {
				res.setContentType("text/html");
				pw.print("<h>Updated succesfully</h>");
			}
//		
//			
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}

}
