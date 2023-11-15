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
			res.setContentType("text/html");
			pw.println("<form action = 'editurl?id="+id+"' method = 'post'>");
			pw.print("<table>");
			pw.println("<tr>");
			pw.println("<td>Name</td>");
			pw.println("<td><input type = 'text', name ='name', value = '" + rs.getString(1)+"'</td>");

			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Designation</td>");
			pw.println("<td><input type = 'text', name ='designation', value = '" + rs.getString(2)+"'</td>");

			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>employeeSalary</td>");
			pw.println("<td><input type = 'text', name ='salary', value = '" + rs.getFloat(3)+"'</td>");

			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type = 'submit' value ='Edit'></td>");

			pw.println("<td><input type = 'reset' value ='Cancel'></td>");

			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
				
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}

}
