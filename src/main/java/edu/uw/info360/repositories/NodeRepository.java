package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Node;;

@Repository
public interface NodeRepository extends CrudRepository<Node, Long> {
	List<Node> findAll();
}
