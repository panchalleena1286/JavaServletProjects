package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servletAssignment1 extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		
		if(ConnecterLogin.Connect(username,password, usertype=="A")) {
			
			RequestDispatcher res =  request.getRequestDispatcher("AdminHomepage");
			res.forward(request, response);
		}	
		  if(ConnecterLogin.Connect(username, password, usertype=="E")){
				RequestDispatcher res1 =  request.getRequestDispatcher("EmployeeHomepage");
				res1.forward(request, response);
		}
	
		else {
			out.println("Invalid Details");
			RequestDispatcher res2 =  request.getRequestDispatcher("Login");
			res2.forward(request, response);
		}
		  
 }
		
		
		
}
