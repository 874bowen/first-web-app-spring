package com.in28minutes.jee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

// localhost:8080?name=in28minutes giving parameters to our url separate url frm params with "?"
// add url - should start with a /
// <!--  when there is a request with nothing behind it it would automatically go to login.do -->
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
//	private Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private UserValidationService service = new UserValidationService();
	
	// handle get with the doGet -> define doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// to get url parameter 
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("password"));
		// to pass the value to our login.jsp we set the attribute to the request
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("password", request.getParameter("password"));
		// to write to the response
//		PrintWriter out = response.getWriter();
//		out.println("Dummy Stuff");
//		out.println("Dummy Stuff2");
		// The way we redirect a request to the JSP 
		// when writing the path we start from the WEB-INF
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean isUserValid = service.isUserValid(name, password);
		if(isUserValid) {
			request.setAttribute("success", "Logged In Successfully!!");
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
}
