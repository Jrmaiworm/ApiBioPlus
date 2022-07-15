package br.com.biomob.restcontroller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biomob.entity.Evaluation;
import br.com.biomob.repository.EvaluationRepository;

@CrossOrigin
@RestController
public class EvaluationController {
	
	@Autowired
	private EvaluationRepository evaluationRepository;
	
	@PostMapping("/evaluation")
	public Evaluation insertEvaluation(@RequestBody Evaluation evaluation) {
		evaluation.setEvaluationId(UUID.randomUUID().toString());
		return evaluationRepository.save(evaluation);
	}
	
	@GetMapping("/evaluation/place/{placeId}")
	public List<Evaluation> findEvaluationByPlaceId(@PathVariable String placeId) {
		return evaluationRepository.findByPlaceId(placeId);
	}
	
	@GetMapping("/evaluation/user/{userId}")
	public List<Evaluation> findEvaluationByUserId(@PathVariable String userId) {
		return evaluationRepository.findByUserId(userId);
	}
	
	@PutMapping("/evaluation/{evaluationId}")
	public void changeEvaluation(@PathVariable String evaluationId, @RequestBody Evaluation evaluation) {
		evaluation.setEvaluationId(evaluationId);
		evaluationRepository.save(evaluation);
	}
	
	@DeleteMapping("/evaluation/{evaluationId}")
	public void removeEvaluation(@PathVariable String evaluationId) {
		evaluationRepository.deleteById(evaluationId);
	}	

}
