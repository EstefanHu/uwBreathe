package edu.uw.info360.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uw.info360.models.Path;

@RestController
@RequestMapping("/api")
public class ApiController {
	@GetMapping("")
	public List<Path> home() {
		return Arrays.asList(
				new Path("Test1", "Test", "This is a test", 17),
				new Path("Test2", "Test", "This also is a Test", 39),
				new Path("Test3", "Test", "...yet another test", 12)
				);
	}
}
