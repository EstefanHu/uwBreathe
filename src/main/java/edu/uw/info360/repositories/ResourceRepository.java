package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Resource;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long>{
	List<Resource> findAll();
}
