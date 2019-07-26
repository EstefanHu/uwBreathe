package edu.uw.info360.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.User;
import edu.uw.info360.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<User> allUsers() {
		return userRepo.findAll();
	}
}
