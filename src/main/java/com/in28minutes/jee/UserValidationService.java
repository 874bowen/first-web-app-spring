package com.in28minutes.jee;

public class UserValidationService {
	public boolean isUserValid(String user, String password) {
		if (user.equals("Bowen") && password.equals("secret"))
			return true;
		return false;
	}
}
