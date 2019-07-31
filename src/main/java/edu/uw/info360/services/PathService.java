package edu.uw.info360.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Path;
import edu.uw.info360.repositories.PathRepository;

@Service
public class PathService {
	private final PathRepository pathRepo;
	
	public PathService(PathRepository pathRepo) {
		this.pathRepo = pathRepo;
	}
	
	public Path createPath(Path p) {
		return pathRepo.save(p);
	}
	
	public List<Path> findAllPaths() {
		return pathRepo.findAll();
	}
	
	public Path findPathByTitle(String title) {
		return pathRepo.findByTitle(title);
	}
	
	public Path findPathById(Long id) {
		Optional<Path> p = pathRepo.findById(id);
		if(p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}
}
