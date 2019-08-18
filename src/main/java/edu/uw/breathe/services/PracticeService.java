package edu.uw.breathe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.uw.breathe.models.Practice;
import edu.uw.breathe.repositories.NodesPracticesRepository;
import edu.uw.breathe.repositories.PracticeRepository;

@Service
public class PracticeService {
	private final PracticeRepository practiceRepo;
	private final NodesPracticesRepository npRepo;
	
	public PracticeService(PracticeRepository practiceRepo,
							NodesPracticesRepository npRepo) {
		this.practiceRepo = practiceRepo;
		this.npRepo = npRepo;
	}
	
	public List<Practice> findAllPractices() {
		return practiceRepo.findAll();
	}
	
	public Practice addPractice(Practice practice) {
		return practiceRepo.save(practice);
	}
	
	public Practice findPracticeById(Long id) {
		Optional<Practice> practice = practiceRepo.findById(id);
		if(practice.isPresent()) {
			return practice.get();
		} else {
			return null;
		}
	}
	
	public Practice updatePractice(Long id, Practice practice) {
		Practice toUpdatePractice = practiceRepo.findById(id).get();
		toUpdatePractice.setTitle(practice.getTitle());
		toUpdatePractice.setDescription(practice.getDescription());
		return practiceRepo.save(toUpdatePractice);
	}
	
	public void deletePractice(Long id) {
		Practice practice = practiceRepo.findById(id).get();
		npRepo.deleteAll(npRepo.findByPractice(practice));
		practiceRepo.delete(practiceRepo.findById(id).get());
	}
}
