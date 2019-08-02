package edu.uw.info360.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.PathsNodes;
import edu.uw.info360.repositories.PathRepository;
import edu.uw.info360.repositories.PathsNodesRepository;

@Service
public class PathsNodesService {
	private final PathsNodesRepository pnRepo;
	private final PathRepository pathRepo;
	
	public PathsNodesService(PathsNodesRepository pnRepo, PathRepository pathRepo) {
		this.pnRepo = pnRepo;
		this.pathRepo = pathRepo;
	}
	
	public PathsNodes createPN(PathsNodes pn) {
		return pnRepo.save(pn);
	}
	
	public List<PathsNodes> findAllPathsNodes() {
		return pnRepo.findAll();
	}
	
	public PathsNodes updatePathsNodes(Long id) {
		PathsNodes pn = pnRepo.findById(id).get();
		pn.update(new Date());
		pnRepo.save(pn);
		return pn;
	}
	
	public List<PathsNodes> findByPathsId(Long pathId) {
		return pnRepo.findByPathOrderByUpdatedAtAsc(pathRepo.findById(pathId).get());
	}
	
	public void deletePathsNodes(Long id) {
		pnRepo.delete(pnRepo.findById(id).get());
	}
}
