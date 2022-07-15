package br.com.biomob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biomob.entity.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, String> {

	List<Evaluation> findByPlaceId(String placeId);

	List<Evaluation> findByUserId(String userId);

}
