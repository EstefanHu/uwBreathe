package edu.uw.breathe.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.uw.breathe.models.Node;
import edu.uw.breathe.models.User;
import edu.uw.breathe.services.NodeService;
import edu.uw.breathe.services.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {
	private final NodeService nodeService;
	private final UserService userService;
	
	public ApiController(NodeService nodeService,
						UserService userService) {
		this.nodeService = nodeService;
		this.userService = userService;
	}
	
	@GetMapping("/theme/{theme}")
	public List<Node> theme(@PathVariable("theme") String theme) {
		List<Node> nodes = nodeService.findByTheme(theme);
		return nodes;
	}
	
	@GetMapping("/location/{id}")
	public Node location(@PathVariable("id") Long id) {
		Node node = nodeService.findNodeById(id);
		return node;
	}
	
	@PostMapping(path="/user", consumes="text/plain", produces="applicatoin/json")
	public User profile(@RequestBody Long userId) {
		User user = userService.findUserById(userId);
		return user;
	}
	
	@PostMapping(path="/search", consumes="text/plain", produces="application/json")
	public Node search(@RequestBody String searchLocation) {
		Node foundNode = nodeService.findByTitle(searchLocation);
		return foundNode;
	}
	
//	TODO suggestions

}
