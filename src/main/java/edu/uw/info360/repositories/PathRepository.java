package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Path;

@Repository
public interface PathRepository extends CrudRepository<Path, Long> {
	List<Path> findAll();
	
	Path findByTitle();
}
