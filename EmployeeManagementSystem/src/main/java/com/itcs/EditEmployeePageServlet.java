package com.itcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditEmployeePageServlet extends HttpServlet {
	
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
			String query = "select name,designation,sallary from employee where id = ?";
			PreparedStatement pt = conn.prepareStatement(query);
			String id = req.getParameter("id");
			pt.setInt(1, Integer.parseInt(id));
			ResultSet rs = pt.executeQuery();
		
			rs.next();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			List<String> columnNames = new ArrayList<>();
			
			for(int i = 1; i <= columnCount; i++) {
				columnNames.add(metaData.getColumnName(i));
			}
		    List<Object> details = new ArrayList<>();
		    for (int i = 1; i <= columnCount; i++) {
		        details.add(rs.getObject(i));
		    }
		    
		    req.setAttribute("details", details);
		    req.setAttribute("columnNames",columnNames);
			req.setAttribute("id", id);		
		    RequestDispatcher dispatch = req.getRequestDispatcher("EditPage.jsp");
		    dispatch.forward(req, res);
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}

}
