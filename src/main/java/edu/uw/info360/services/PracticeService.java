package edu.uw.info360.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.Practice;
import edu.uw.info360.repositories.PracticeRepository;

@Service
public class PracticeService {
	private final PracticeRepository practiceRepo;
	
	public PracticeService(PracticeRepository practiceRepo) {
		this.practiceRepo = practiceRepo;
	}
	
	public List<Practice> findAllPractices() {
		return practiceRepo.findAll();
	}
	
	public Practice addPractice(Practice practice) {
		return practiceRepo.save(practice);
	}
}
