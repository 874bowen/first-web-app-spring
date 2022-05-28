package com.in28minutes.login;

public class UserValidationService {
	public boolean isUserValid(String name, String password) {
		if (name.equals("Bowen") && password.equals("secret"))
			return true;
		return false;
	}
}
