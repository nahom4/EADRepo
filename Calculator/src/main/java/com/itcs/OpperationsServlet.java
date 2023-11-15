package com.itcs;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpperationsServlet
 */
@WebServlet("/OpperationsServlet")
public class OpperationsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opperations = request.getParameter("opperation");
		if ("+".equals(opperations)) {
			RequestDispatcher dispatch = request.getRequestDispatcher("/AdditionServlet");
			dispatch.forward(request, response);
			
		}
		
		else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/MultiplicationServlet");
			dispatch.forward(request, response);
		}		
	}

}
