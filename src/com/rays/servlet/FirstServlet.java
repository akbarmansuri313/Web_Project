package com.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
	
	public class FirstServlet extends HttpServlet{
	
		@Override
		
		
		protected void  doGet(HttpServletRequest request, HttpServletResponse responce)
		
					throws ServletException, IOException{
			
			System.out.println("in do get method");
			responce.sendRedirect ("Firstview.jsp");
			
		}
		
		@Override
		
		protected void doPost(HttpServletRequest request, HttpServletResponse responce)
		
						throws ServletException, IOException{
			
		    System.out.println("in do post method");
		    
		    System.out.println(request.getParameter("firstName"));
		    System.out.println(request.getParameter("lastName"));
		    System.out.println(request.getParameter("loginId"));
		    System.out.println(request.getParameter("password"));
		    System.out.println(request.getParameter("dob"));
		    
		}
		
		
		
		
}
