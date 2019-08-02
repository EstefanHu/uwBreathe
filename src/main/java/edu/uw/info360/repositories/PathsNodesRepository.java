package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.PathsNodes;

@Repository
public interface PathsNodesRepository extends CrudRepository<PathsNodes, Long> {
	List<PathsNodes> findAll();
	List<PathsNodes> findByPid(Long pathId);
}
