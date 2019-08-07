package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Practice;
import edu.uw.info360.models.PracticesNodes;

@Repository
public interface PracticesNodesRepository extends CrudRepository<PracticesNodes, Long>{
	List<PracticesNodes> findAll();
	
	List<PracticesNodes> findByPracticeOrderByUpdateAtAsc(Practice practice);
}
