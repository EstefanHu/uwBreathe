package edu.uw.info360.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Node;
import edu.uw.info360.repositories.NodeRepository;
import edu.uw.info360.repositories.NodesPracticesRepository;

@Service
public class NodeService {
	private final NodeRepository nodeRepo;
	private final NodesPracticesRepository npRepo;
	
	public NodeService(NodeRepository nodeRepo,
						NodesPracticesRepository npRepo) {
		this.nodeRepo = nodeRepo;
		this.npRepo = npRepo;
	}
	
	public Node createNode(Node node) {
		return nodeRepo.save(node);
	}
	
	public List<Node> findAllNodes() {
		return nodeRepo.findAll();
	}
	
	public Node findByTitle(String title) {
		return nodeRepo.findByTitle(title);
	}
	
	public List<Node> findByTheme(String theme) {
		return nodeRepo.findByTheme(theme);
	}
	
	public Node findNodeById(Long id) {
		Optional<Node> node = nodeRepo.findById(id);
		if(node.isPresent()) {
			return node.get();
		} else {
			return null;
		}
	}
	
	public Node updateNode(Long id, Node node) {
		Node toUpdateNode = nodeRepo.findById(id).get();
		toUpdateNode.setTitle(node.getTitle());
		toUpdateNode.setTheme(node.getTheme());
		toUpdateNode.setPhoto(node.getPhoto());
		toUpdateNode.setLatitude(node.getLatitude());
		toUpdateNode.setLongitude(node.getLongitude());
		return nodeRepo.save(toUpdateNode);
	}
	
	public void deleteNode(Long id) {
		Node node = nodeRepo.findById(id).get();
		npRepo.deleteAll(npRepo.findByNode(node));
		nodeRepo.delete(node);
	}
}
