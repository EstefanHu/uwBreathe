package edu.uw.breathe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.breathe.models.Node;
import edu.uw.breathe.models.NodesPractices;
import edu.uw.breathe.models.Practice;

@Repository
public interface NodesPracticesRepository extends CrudRepository<NodesPractices, Long>{
	List<NodesPractices> findAll();

	List<NodesPractices> findByNode(Node node);
	List<NodesPractices> findByPractice(Practice practice);
	
	List<NodesPractices> findByNodeOrderByUpdatedAtAsc(Node node);
}
