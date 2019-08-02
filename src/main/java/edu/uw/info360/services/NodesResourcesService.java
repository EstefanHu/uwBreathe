package edu.uw.info360.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.NodesResources;
import edu.uw.info360.repositories.NodeRepository;
import edu.uw.info360.repositories.NodesResourcesRepository;

@Service
public class NodesResourcesService {
	private final NodesResourcesRepository nrRepo;
	private final NodeRepository nodeRepo;
	
	public NodesResourcesService(NodesResourcesRepository nrRepo, NodeRepository nodeRepo) {
		this.nrRepo = nrRepo;
		this.nodeRepo = nodeRepo;
	}
	
	public NodesResources createNR(NodesResources nr) {
		return nrRepo.save(nr);
	}
	
	public List<NodesResources> findAllNodesResources() {
		return nrRepo.findAll();
	}
	
	public NodesResources updateNodesResources(Long id) {
		NodesResources nr = nrRepo.findById(id).get();
		nr.update(new Date());
		nrRepo.save(nr);
		return nr;
	}
	
	public List<NodesResources> findByNodesId(Long nodeId) {
		return nrRepo.findByNodeOrderByUpdatedAtAsc(nodeRepo.findById(nodeId).get());
	}
	
	public void deleteNodesResources(Long id) {
		nrRepo.delete(nrRepo.findById(id).get());
	}
}
