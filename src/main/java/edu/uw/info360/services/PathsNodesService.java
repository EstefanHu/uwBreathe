package edu.uw.info360.services;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.PathsNodes;
import edu.uw.info360.repositories.PathsNodesRepository;

@Service
public class PathsNodesService {
	private final PathsNodesRepository pnRepo;
	
	public PathsNodesService(PathsNodesRepository pnRepo) {
		this.pnRepo = pnRepo;
	}
	
	public PathsNodes createPN(PathsNodes pn) {
		return pnRepo.save(pn);
	}
}
