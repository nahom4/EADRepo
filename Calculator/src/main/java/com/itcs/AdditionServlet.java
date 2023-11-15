package com.itcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionServlet
 */
@WebServlet("/AdditionServlet")
public class AdditionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int ans = Integer.parseInt(request.getParameter("input1")) + Integer.parseInt(request.getParameter("input2"));
	
		request.setAttribute("result", ans);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SimpleCalculatorPage.jsp");
		dispatcher.forward(request, response);
		
	}
}
