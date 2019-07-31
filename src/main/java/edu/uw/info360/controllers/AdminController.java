package edu.uw.info360.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	@RequestMapping("/createpath")
	public String createPath() {
		return "Admin/createPath.jsp";
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
