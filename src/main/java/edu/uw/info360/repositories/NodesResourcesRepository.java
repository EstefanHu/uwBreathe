package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Node;
import edu.uw.info360.models.NodesResources;

@Repository
public interface NodesResourcesRepository extends CrudRepository<NodesResources, Long> {
	List<NodesResources> findAll();
	
	List<NodesResources> findByNodeOrderByUpdatedAtAsc(Node node);
}
