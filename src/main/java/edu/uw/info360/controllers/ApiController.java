package edu.uw.info360.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uw.info360.models.Node;
import edu.uw.info360.services.NodeService;

@RestController
@RequestMapping("/api")
public class ApiController {
	private final NodeService nodeService;
	
	public ApiController(NodeService nodeService) {
		this.nodeService = nodeService;
	}
	
//	TODO Home "Themes" no database call
	
	@GetMapping("/{theme}")
	public List<Node> theme(@PathVariable("theme") String theme) {
		List<Node> nodes = nodeService.findByTheme(theme);
		return nodes;
	}
	
//	TODO Location - call node and related practices and resources
	
//	TODO Profile - call User and User History and paths stored
	
//	TODO Suggestions - waiting on UXI
	
//	TODO Search Location functionality
	
}
