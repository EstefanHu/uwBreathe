package edu.uw.info360.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/location/{id}")
	public Node location(@PathVariable("id") Long id) {
		Node node = nodeService.findNodeById(id);
		return node;
	}
	
//	TODO Profile - call User and User History and paths stored
	
//	TODO Suggestions - waiting on UXI
	
//	TODO Search Location functionality
	@PostMapping(path="/search", consumes = "application/json", produces="application/json") {
		public List<Node> search(@RequestBody String searchLocation) {
			List<Node> foundNodes = nodeService.findByTitle(searchLocation);
			return foundNodes;
		}
	}
	
}
