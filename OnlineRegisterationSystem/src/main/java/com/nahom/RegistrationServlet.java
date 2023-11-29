package com.nahom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
			
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "Insert Into users(name, email, password) values(?,?,?)";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1, name);
			pt.setString(2, email);
			pt.setString(3, password);
			
			pt.executeUpdate();
			DatabaseConnection.closeConnection(conn);
			response.sendRedirect("Confirmation.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
	}
	

}
