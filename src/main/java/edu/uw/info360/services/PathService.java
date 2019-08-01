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
	
	public Path createPath(Path path) {
		return pathRepo.save(path);
	}
	
	public List<Path> findAllPaths() {
		return pathRepo.findAll();
	}
	
	public Path findPathByTitle(String title) {
		return pathRepo.findByTitle(title);
	}
	
	public Path findPathById(Long id) {
		Optional<Path> path = pathRepo.findById(id);
		if(path.isPresent()) {
			return path.get();
		} else {
			return null;
		}
	}
	
	public void updatePath(Long id, Path path) {
		Path toUpdatePath = pathRepo.findById(id).get();
		toUpdatePath.setTitle(path.getTitle());
		toUpdatePath.setDescription(path.getDescription());
		toUpdatePath.setTheme(path.getTheme());
		toUpdatePath.setTimeDuration(path.getTimeDuration());
		pathRepo.save(toUpdatePath);
	}
}
