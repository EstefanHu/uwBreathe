package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Node;
import edu.uw.info360.models.NodesPractices;
import edu.uw.info360.models.Practice;

@Repository
public interface NodesPracticesRepository extends CrudRepository<NodesPractices, Long>{
	List<NodesPractices> findAll();

	List<NodesPractices> findByNode(Node node);
	List<NodesPractices> findByPractice(Practice practice);
	
	List<NodesPractices> findByNodeOrderByUpdatedAtAsc(Node node);
}
