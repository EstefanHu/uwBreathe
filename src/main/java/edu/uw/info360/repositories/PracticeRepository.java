package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.info360.models.Practice;

@Repository
public interface PracticeRepository extends CrudRepository<Practice, Long>{
	List<Practice> findAll();
}
