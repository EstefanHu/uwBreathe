package edu.uw.info360.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uw.info360.models.Resource;
import edu.uw.info360.services.ResourceService;

@RestController
@RequestMapping("/api")
public class ApiController {
	private final ResourceService resourceService;
	
	public ApiController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
//	TODO Home "Themes" no database call
	
//	TODO Theme - call nodes by specific Theme
	
//	TODO Location - call node and related practices and resources
	
//	TODO Profile - call User and User History and paths stored
	
//	TODO Suggestions - waiting on UXI
	
//	TODO Search Location functionality
	
}
