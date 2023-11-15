package com.itcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
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
			String query = "insert into employee(name, designation, sallary)values(?, ?, ?)";
			PreparedStatement pt  = conn.prepareStatement(query);
			System.out.print("works fine");
			String name = req.getParameter("name");
			String designation = req.getParameter("designation");
			float salary = Float.parseFloat(req.getParameter("salary"));
			pt.setString(1, name);
			pt.setString(2, designation);
			pt.setFloat(3, salary);
			int val = pt.executeUpdate();
			System.out.print(val);
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}
}
