package edu.uw.info360.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uw.info360.models.Node;
import edu.uw.info360.models.Path;
import edu.uw.info360.services.NodeService;
import edu.uw.info360.services.PathService;
import edu.uw.info360.validators.PathValidator;

@Controller
@RequestMapping("admin")
public class AdminController {
	private final PathService pathService;
	private final NodeService nodeService;
	
	private final PathValidator pathValidator;
	
	public AdminController(PathService pathService, PathValidator pathValidator, 
														NodeService nodeService) {
		this.pathService = pathService;
		this.pathValidator = pathValidator;
		this.nodeService = nodeService;
	}
	@RequestMapping("")
	public String control(Model model) {
		List<Path> paths = pathService.findAllPaths();
		List<Node> nodes = nodeService.findAllNodes();
		model.addAttribute("nodes", nodes);
		model.addAttribute("paths", paths);
		return "Admin/control.jsp";
	}
	
	@RequestMapping("/createPath")
	public String createPath(@ModelAttribute("path") Path path) {
		return "Admin/createPath.jsp";
	}
	
	@RequestMapping(value="/ingestNewPath", method=RequestMethod.POST)
	public String ingestNewPath(@Valid @ModelAttribute("path") Path newPath, BindingResult result) {
		pathValidator.validate(newPath, result);
		if(result.hasErrors()) {
			return "Admin/createPath.jsp";
		}
		pathService.createPath(newPath);
		return "redirect:/admin/";
	}
	
	@RequestMapping("/editPath/{id}")
	public String editPath(Model model, @PathVariable("id") Long id) {
		Path path = pathService.findPathById(id);
		model.addAttribute("path", path);
		return "Admin/editPath.jsp";
	}
//	
//	TODO: Create route to ingest new Path
//	
	
	@RequestMapping("/createNode")
	public String createNode(@ModelAttribute("node") Node node) {
		return "Admin/createNode.jsp";
	}
	
	@RequestMapping(value="/ingestNewNode", method=RequestMethod.POST)
	public String ingestNewPath(@Valid @ModelAttribute("node") Node newNode, BindingResult result) {
//		TODO: Create Node Validation
		nodeService.createNode(newNode);
		return "redirect:/admin/";
	}
	
	@RequestMapping("/editNode/{id}")
	public String editNode(Model model, @PathVariable("id") Long id, @ModelAttribute("updateNode") Node updateNode) {
		Node node = nodeService.findNodeById(id);
		model.addAttribute("node", node);
		return "Admin/editNode.jsp";
	}
//	
//	TODO: Create route to ingest new Node
//	
	
}
