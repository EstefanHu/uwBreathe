package edu.uw.info360.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.uw.info360.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
}
