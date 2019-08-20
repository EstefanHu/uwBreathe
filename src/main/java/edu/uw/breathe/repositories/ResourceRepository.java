package edu.uw.breathe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.breathe.models.Resource;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long>{
	List<Resource> findAll();
}
