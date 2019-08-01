package edu.uw.info360.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Node;
import edu.uw.info360.repositories.NodeRepository;

@Service
public class NodeService {
	private final NodeRepository nodeRepo;
	
	public NodeService(NodeRepository nodeRepo) {
		this.nodeRepo = nodeRepo;
	}
	
	public Node createNode(Node node) {
		return nodeRepo.save(node);
	}
	
	public List<Node> findAllNodes() {
		return nodeRepo.findAll();
	}
	
	public Node getNodeById(Long id) {
		Optional<Node> node = nodeRepo.findById(id);
		if(node.isPresent()) {
			return node.get();
		} else {
			return null;
		}
	}
}
