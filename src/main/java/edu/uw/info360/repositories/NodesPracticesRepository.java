package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Node;
import edu.uw.info360.models.NodesPractices;

@Repository
public interface NodesPracticesRepository extends CrudRepository<NodesPractices, Long>{
	List<NodesPractices> findAll();
	
//	NEEDS UPDATE
	List<NodesPractices> findByNodeOrderByUpdatedAtAsc(Node node);
}
