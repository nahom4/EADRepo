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
			RequestDispatcher dispatcher = req.getRequestDispatcher("ViewPage.jsp");
			
			List<String> columnNames = new ArrayList<>();
			List<List<Object>> rows = new ArrayList<>();

			ResultSetMetaData metaData = rs.getMetaData();

			// Extract column names
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
			    columnNames.add(metaData.getColumnName(i));
			}

			// Extract rows
			while (rs.next()) {
			    List<Object> row = new ArrayList<>();
			    for (int i = 1; i <= columnCount; i++) {
			        row.add(rs.getObject(i));
			    }
			    rows.add(row);
			}

			System.out.print(columnNames);
			// Set these lists as attributes in the request or another suitable scope
			req.setAttribute("columnNames", columnNames);
			req.setAttribute("rows", rows);

	
			dispatcher.forward(req, res);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
