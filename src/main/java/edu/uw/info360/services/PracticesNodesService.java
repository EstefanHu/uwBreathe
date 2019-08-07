package edu.uw.info360.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.uw.info360.models.PracticesNodes;
import edu.uw.info360.repositories.PracticeRepository;
import edu.uw.info360.repositories.PracticesNodesRepository;

@Service
public class PracticesNodesService {
	private final PracticesNodesRepository pnRepo;
	private final PracticeRepository practiceRepo;
	
	
	public PracticesNodesService(PracticesNodesRepository pnRepo, PracticeRepository practiceRepo) {
		this.pnRepo = pnRepo;
		this.practiceRepo = practiceRepo;
	}
	
	public PracticesNodes createPN(PracticesNodes pn) {
		return pnRepo.save(pn);
	}
	
	public List<PracticesNodes> findAllPracticesNodes() {
		return pnRepo.findAll();
	}
	
	public PracticesNodes updatePracticesNodes(Long id) {
		PracticesNodes pn = pnRepo.findById(id).get();
		pn.update(new Date());
		pnRepo.save(pn);
		return pn;
	}
	
	public List<PracticesNodes> findByPracticesId(Long practiceId) {
		return pnRepo.findByPracticeOrderByUpdateAtAsc(practiceRepo.findById(practiceId).get());
	}
	
	public void deletePracticesNodes(Long id) {
		pnRepo.delete(pnRepo.findById(id).get());
	}
}
