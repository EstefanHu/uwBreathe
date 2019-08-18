package edu.uw.breathe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.breathe.models.Node;;

@Repository
public interface NodeRepository extends CrudRepository<Node, Long> {
	List<Node> findAll();
	
	Node findByTitle(String title);
	
	List<Node> findByTheme(String theme);
}
