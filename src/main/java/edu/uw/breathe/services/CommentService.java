package edu.uw.breathe.services;

import org.springframework.stereotype.Service;

import edu.uw.breathe.models.Comment;
import edu.uw.breathe.models.Practice;
import edu.uw.breathe.repositories.CommentRepository;

@Service
public class CommentService {
	private final CommentRepository commentRepo;
	
	public CommentService(CommentRepository commentRepo) {
		this.commentRepo = commentRepo;
	}
	
	public Comment createComment(Comment comment, Practice practice) {
		comment.setPractice(practice);
		return commentRepo.save(comment);
	}
}
