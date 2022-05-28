package com.in28minutes.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.login.UserValidationService;

/* spring mvc
 * DispatcherServlet -> Front Controller
 * /login -> Login Controller (Handler)
 * Hello World to the dispatcher 
 * Hello World
 * Tell dispatcher when login returned send it to login.jsp
 * model is passed from the controller to the dispatcherServlet & from dispathcherServlet to the View
 * Configure View Resolver for this
 * prefix -> /WEB-INF/views/
 * suffix -> .jsp
 * Result = /WEB-INF/views/login.jsp
 * login.jsp -> View
*/
@Controller // this tells spring that this a controller => handles web requests
public class LoginController {
	
	UserValidationService loginService = new UserValidationService();
	// Mapping this url to this method by default it handles all requests unless restricted
	// with by adding them method= after value=
	@RequestMapping(value="/login", method = RequestMethod.GET)
	// @ResponseBody // whatever is returned from the Controller Hello World is sent back as response
	public String showLoginPage() {
		// return "Hello World"; // @ResponseBody
		return "login"; // when you want to go to the login.jsp remove @ResponseBody
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String handleLoginPage(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		// here to get the values from user we use @RequestParam -> no specifying attribute
		if (!loginService.isUserValid(name, password)) {
			model.put("errorMessage", "Invalid Credentials!");
			return "login"; 
		}
		model.put("name", name); // now we've sent it to the View
		model.put("password", password);
		model.put("success", "You are logged in successfully!");
		System.out.println(name); // showing in the console but not in the browser
		// model is used to pass the information between the Controller and the View by adding parameter 
		// ModelMap model
		return "welcome";
		
	}
}
