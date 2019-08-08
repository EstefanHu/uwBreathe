package edu.uw.info360.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Content;
import edu.uw.info360.repositories.ContentRepository;

@Service
public class ContentService {
	private final ContentRepository contentRepo;
	
	public ContentService(ContentRepository contentRepo) {
		this.contentRepo = contentRepo;
	}
	
	public List<Content> findAllContent() {
		return contentRepo.findAll();
	}
}
