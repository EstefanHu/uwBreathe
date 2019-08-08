package edu.uw.info360.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.uw.info360.models.Node;
import edu.uw.info360.services.NodeService;

@Controller
public class HomeController {
	private final NodeService nodeService;
	
	public HomeController(NodeService nodeService) {
		this.nodeService = nodeService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "Home/index.jsp";
	}
	
	@RequestMapping("/theme/{theme}")
	public String theme(@PathVariable("theme") String theme, Model model) {
		List<Node> themedNodes = nodeService.findByTheme(theme);
		model.addAttribute("theme", themedNodes);
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
