package edu.uw.breathe.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.uw.breathe.models.Node;
import edu.uw.breathe.models.Practice;
import edu.uw.breathe.services.NodeService;
import edu.uw.breathe.services.PracticeService;

@Controller
public class HomeController {
	private final NodeService nodeService;
	private final PracticeService practiceService;
	
	public HomeController(NodeService nodeService,
						PracticeService practiceService) {
		this.nodeService = nodeService;
		this.practiceService = practiceService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "Home/index.jsp";
	}
	
	@RequestMapping("/{theme}")
	public String theme(@PathVariable("theme") String theme, Model model) {
		List<Node> themedNodes = nodeService.findByTheme(theme);
		if (themedNodes.size() == 0) return "redirect:/";
		model.addAttribute("theme", theme);
		model.addAttribute("themedNodes", themedNodes);
		return "Home/index.jsp";
	}
	
	@RequestMapping("/location/{id}")
	public String location(@PathVariable("id") Long id, HttpSession session, Model model) {
		Node chosenNode = nodeService.findNodeById(id);
		session.setAttribute("nodeId", id);
		List<Practice> practices = chosenNode.getPractices();
		model.addAttribute("node", chosenNode);
		model.addAttribute("practices", practices);
		return "Home/location.jsp";
	}
	
	@RequestMapping("/practice/{id}")
	public String practice(@PathVariable("id") Long id, HttpSession session, Model model) {
		Practice thisPractice = practiceService.findPracticeById(id);
		session.setAttribute("practiceId", id);
		model.addAttribute(thisPractice);
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