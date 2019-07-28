package edu.uw.info360.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Resource;
import edu.uw.info360.repositories.ResourceRepository;

@Service
public class ResourceService {
	private final ResourceRepository resourceRepo;
	
	public ResourceService(ResourceRepository resourceRepo) {
		this.resourceRepo = resourceRepo;
	}
	
	public List<Resource> allResources() {
		return resourceRepo.findAll();
	}
}
