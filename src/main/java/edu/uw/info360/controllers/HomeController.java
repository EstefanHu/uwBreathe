package edu.uw.info360.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String home() {
		return "Home/index.jsp";
	}
	
	@RequestMapping("/theme/{id}")
	public String theme(@PathVariable("id") Long id) {
		
		return "Home/index.jsp";
	}
	
	@RequestMapping("/location/{id}")
	public String location(@PathVariable("id") Long id) {
		return "Home/location.jsp";
	}
	
	@RequestMapping("/practice/{id}")
	public String practice(@PathVariable("id") Long id) {
		return "Home/practice.jsp";
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
