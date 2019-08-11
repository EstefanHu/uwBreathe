package edu.uw.info360.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Node;
import edu.uw.info360.models.NodesPractices;
import edu.uw.info360.models.Practice;
import edu.uw.info360.repositories.NodeRepository;
import edu.uw.info360.repositories.NodesPracticesRepository;

@Service
public class NodesPracticesService {
	private final NodesPracticesRepository npRepo;
	private final NodeRepository nodeRepo;
	
	public NodesPracticesService(NodesPracticesRepository npRepo, NodeRepository nodeRepo) {
		this.npRepo = npRepo;
		this.nodeRepo = nodeRepo;
	}
	
	public NodesPractices createNP(NodesPractices np) {
		return npRepo.save(np);
	}
	
	public List<NodesPractices> findAllNodesPractices() {
		return npRepo.findAll();
	}
	
	public NodesPractices updateNodesPractices(Long id) {
		NodesPractices np = npRepo.findById(id).get();
		np.update(new Date());
		npRepo.save(np);
		return np;
	}
	
	public List<NodesPractices> findByNodesId(Long nodeId) {
		return npRepo.findByNodeOrderByUpdatedAtAsc(nodeRepo.findById(nodeId).get());
	}
	
	public void deleteNodesPractices(Long id) {
		NodesPractices np = npRepo.findById(id).get();
		Node node = np.getNode();
		Practice practice = np.getPractice();
		node.removePractice(practice);
		npRepo.delete(np);
	}
}
