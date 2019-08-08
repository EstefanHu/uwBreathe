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
}
