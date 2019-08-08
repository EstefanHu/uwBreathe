package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Content;

@Repository
public interface ContentRepository extends CrudRepository<Content, Long> {
	List<Content> findAll();
}
