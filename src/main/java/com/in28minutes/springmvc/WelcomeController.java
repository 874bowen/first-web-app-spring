package com.in28minutes.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* spring mvc
 * DispatcherServlet -> Front Controller
 * /login -> Login Controller (Handler)
 * Hello World to the dispatcher 
 * Hello World
 * Tell dispatcher when login returned send it to login.jsp
 * Configure View Resolver for this
 * prefix -> /WEB-INF/views/
 * suffix -> .jsp
 * Result = /WEB-INF/views/login.jsp
 * login.jsp -> View
*/
@Controller // this tells spring that this a controller => handles web requests
public class WelcomeController {
	
	// Mapping this url to this method
	@RequestMapping(value="/welcome")
	// @ResponseBody // whatever is returned from the Controller Hello World is sent back as response
	public String sayHello() {
		// return "Hello World"; // @ResponseBody
		return "welcome"; // when you want to go to the login.jsp remove @ResponseBody
	}
}
