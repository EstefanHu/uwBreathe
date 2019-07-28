package edu.uw.info360.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Path;
import edu.uw.info360.repositories.PathRepository;

@Service
public class PathService {
	private final PathRepository pathRepo;
	
	public PathService(PathRepository pathRepo) {
		this.pathRepo = pathRepo;
	}
	
	public List<Path> allPaths() {
		return pathRepo.findAll();
	}
}
