package com.itcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
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
		
			int id = Integer.parseInt(req.getParameter("id"));
			pw.print(id);
			String query = "DELETE FROM employee WHERE id = ?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setInt(1, id);
			pt.executeUpdate();
			
			res.sendRedirect(req.getContextPath() + "/view");
			
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}

	

}
