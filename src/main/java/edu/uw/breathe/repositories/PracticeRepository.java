package edu.uw.breathe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uw.breathe.models.Practice;

@Repository
public interface PracticeRepository extends CrudRepository<Practice, Long>{
	List<Practice> findAll();
}
