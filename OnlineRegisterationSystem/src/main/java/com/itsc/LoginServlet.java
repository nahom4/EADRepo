package com.itsc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nahom.DatabaseConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "select * from users where password = ? and email = ?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1, email);
			pt.setString(2,password);
			ResultSet res = pt.executeQuery();
			HttpSession session = request.getSession();
			if (res.next()) {
				String name = res.getString(1);
				session.setAttribute("name", name);
				conn.close();
				RequestDispatcher dp = request.getRequestDispatcher("WelcomePage.jsp");
				dp.forward(request, response);
			}
			else {
				conn.close();
				response.sendRedirect("login.jsp");
				
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
