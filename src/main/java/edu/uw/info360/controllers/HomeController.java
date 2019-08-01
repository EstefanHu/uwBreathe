package edu.uw.info360.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "Home/index.jsp";
	}
	
	@RequestMapping("/profile")
	public String profile() {
		return "Home/profile.jsp";
	}
	
//	
//	TODO: Update profile information
//	
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/login/";
	}
}
