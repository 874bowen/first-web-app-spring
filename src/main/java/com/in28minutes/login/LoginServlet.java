package com.in28minutes.login;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 // Method descriptor #15 ()V
 public void init() throws javax.servlet.ServletException;
 // Method descriptor #37 (Ljavax/servlet/ServletRequest;Ljavax/servlet/ServletResponse;)V
 public void service(javax.servlet.ServletRequest arg0, javax.servlet.ServletResponse arg1) throws javax.servlet.ServletException, java.io.IOException;
 // Method descriptor #15 ()V
 public void destroy();
 */
// 1. extends javax.servlet.http.HttpServlet
// 2. @WebServlet(urlPatterns="/login.do") --->> assigning a url to the servlet
// and helps us define the url patterns for this class
// 3. doGet(....)
// 4. How is the response created?
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	// the doGet() method is used to handle GET HttpRequests
	// input-> request :: output -> response
	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter(); //write to the browser
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Yahoo</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("My first Servlet");
		out.println("</body>");
		out.println("</html>");
	}

}