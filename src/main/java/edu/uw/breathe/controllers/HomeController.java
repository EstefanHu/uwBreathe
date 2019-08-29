package edu.uw.breathe.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uw.breathe.models.Comment;
import edu.uw.breathe.models.Node;
import edu.uw.breathe.models.Practice;
import edu.uw.breathe.services.CommentService;
import edu.uw.breathe.services.NodeService;
import edu.uw.breathe.services.PracticeService;

@Controller
public class HomeController {
	private final NodeService nodeService;
	private final PracticeService practiceService;
	private final CommentService commentService;
	
	public HomeController(NodeService nodeService,
						PracticeService practiceService,
						CommentService commentService) {
		this.nodeService = nodeService;
		this.practiceService = practiceService;
		this.commentService = commentService;
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
		return "Home/theme.jsp";
	}
	
	@RequestMapping("/location/{id}")
	public String location(@PathVariable("id") Long id, HttpSession session, Model model) {
		Node chosenNode = nodeService.findNodeById(id);
		session.setAttribute("chosenNode", chosenNode);
		model.addAttribute("chosenNode", chosenNode);
		return "Home/location.jsp";
	}
	
	@RequestMapping("/practice/{id}")
	public String practice(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("createComment") Comment createComment) {
		Practice thisPractice = practiceService.findPracticeById(id);
		session.setAttribute("practice", thisPractice);
		Node chosenNode = (Node) session.getAttribute("chosenNode");
		model.addAttribute("chosenNode", chosenNode);
		model.addAttribute(thisPractice);
		return "Home/practice.jsp";
	}
	
	@RequestMapping(value="/createComment", method=RequestMethod.POST)
	public String createComment(@Valid @ModelAttribute("newComment") Comment newComment, HttpSession session) {
		Practice practice = (Practice) session.getAttribute("practice");
		commentService.createComment(newComment, practice);
		return "redirect:/practice/" + practice.getId();
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/login/";
	}
}
