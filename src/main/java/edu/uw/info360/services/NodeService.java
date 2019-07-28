package edu.uw.info360.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Node;
import edu.uw.info360.repositories.NodeRepository;

@Service
public class NodeService {
	private final NodeRepository nodeRepo;
	
	public NodeService(NodeRepository nodeRepo) {
		this.nodeRepo = nodeRepo;
	}
	
	public List<Node> allNodes() {
		return nodeRepo.findAll();
	}
}
