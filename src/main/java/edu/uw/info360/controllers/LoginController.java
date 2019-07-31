package edu.uw.info360.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
	@RequestMapping("")
	public String login() {
		return "Login/login.jsp";
	}
	
//	
//	TODO: Create route to login user
//
	
	@RequestMapping("/loginassistant")
	public String loginAssistant() {
		return "Login/loginAssistant.jsp";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "Login/register";
	}
	
//	
//	TODO: Create Route to Register User
//	
	
}
