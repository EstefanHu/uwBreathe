package edu.uw.breathe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.uw.breathe.models.Resource;
import edu.uw.breathe.repositories.ResourceRepository;

@Service
public class ResourceService {
	private final ResourceRepository resourceRepo;
	
	public ResourceService(ResourceRepository resourceRepo) {
		this.resourceRepo = resourceRepo;
	}
	
	public List<Resource> findAllResources() {
		return resourceRepo.findAll();
	}
	
	public Resource createResource(Resource resource) {
		return resourceRepo.save(resource);
	}
	
	public Resource findResourceById(Long id) {
		Optional<Resource> resource = resourceRepo.findById(id);
		if(resource.isPresent()) {
			return resource.get();
		} else {
			return null;
		}
	}
	
	public Resource updateResource(Long id, Resource resource) {
		Resource toUpdateResource = resourceRepo.findById(id).get();
		toUpdateResource.setTitle(resource.getTitle());
		toUpdateResource.setDescription(resource.getDescription());
		toUpdateResource.setEmail(resource.getEmail());
		toUpdateResource.setPhoneNumber(resource.getPhoneNumber());
		toUpdateResource.setUrl(resource.getUrl());
		return resourceRepo.save(toUpdateResource);
	}
	
	public void deleteResource(Long id) {
		resourceRepo.delete(resourceRepo.findById(id).get());
	}
}
