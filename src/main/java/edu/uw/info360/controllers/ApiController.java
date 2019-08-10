package edu.uw.info360.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uw.info360.models.Node;
import edu.uw.info360.models.User;
import edu.uw.info360.services.NodeService;
import edu.uw.info360.services.UserService;

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
	public List<Node> search(@RequestBody String searchLocation) {
		List<Node> foundNodes = nodeService.findByTitle(searchLocation);
		return foundNodes;
	}
	
//	TODO suggestions

}
