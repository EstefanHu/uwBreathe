package edu.uw.info360.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String control() {
		return "Admin/control.jsp";
	}
	
	@RequestMapping("/createpath")
	public String createPath(@ModelAttribute("path") Path path) {
		return "Admin/createPath.jsp";
	}
	
	@RequestMapping(value="/ingestnewpath", method=RequestMethod.POST)
	public String ingestNewPath(@Valid @ModelAttribute("path") Path newPath, BindingResult result) {
		pathValidator.validate(newPath, result);
		if(result.hasErrors()) {
			return "Admin/createPath.jsp";
		}
		pathService.createPath(newPath);
		return "redirect:/admin/";
	}
//	
//	TODO: Create route to ingest new Path
//	
	
	@RequestMapping("/createnode")
	public String createNode() {
		return "Admin/createNode.jsp";
	}
	
//	
//	TODO: Create route to ingest new Node
//	
	
}
