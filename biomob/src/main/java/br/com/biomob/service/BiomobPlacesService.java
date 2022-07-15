package br.com.biomob.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biomob.entity.Evaluation;
import br.com.biomob.interfaces.IBiomobPlacesService;
import br.com.biomob.interfaces.IGooglePlacesRestClientService;
import br.com.biomob.model.BiomobPlacesReturn;
import br.com.biomob.model.Categories;
import br.com.biomob.model.Place;
import br.com.biomob.model.google.GoogleResponse;
import br.com.biomob.model.google.GoogleResult;
import br.com.biomob.repository.EvaluationRepository;

@Service
public class BiomobPlacesService implements IBiomobPlacesService{
	
	private static final String ALL_CATEGORIES = "ALL_CATEGORIES";
	
	@Autowired
	IGooglePlacesRestClientService iGooglePlacesRestClientService;

//	@Autowired
//	private BiomobRepository biomobRepository;
	
	@Autowired
	private EvaluationRepository evaluationRepository;
	
	@Override
	public BiomobPlacesReturn findPlacesByGeoreference(String category, String latitude, String longitude, String range) {
		
		BiomobPlacesReturn biomobPlacesReturn = new BiomobPlacesReturn();
		
		List<String> categories = generateCategoryList(category);
		
		for (String categoryValue : categories) {
			GoogleResponse googleResponse = iGooglePlacesRestClientService.findPlaces(categoryValue, latitude, longitude, range);
			biomobPlacesReturn = toBiomobPlacesReturn(googleResponse);
		}
		
		return biomobPlacesReturn;
	}

	@Override
	public BiomobPlacesReturn nextPage(String actualPage, String nextPageToken) {
		
		BiomobPlacesReturn biomobPlacesReturn = new BiomobPlacesReturn();
		
		GoogleResponse googleResponse = iGooglePlacesRestClientService.nextPage(actualPage, nextPageToken);
		biomobPlacesReturn = toBiomobPlacesReturn(googleResponse);
		
		return biomobPlacesReturn;
	}

	private List<String> generateCategoryList(String category) {
		
		List<String> categories = new ArrayList<>();
		
		if (category != null && category.equals(ALL_CATEGORIES)) {
			
			for (Categories categoryValue : Categories.values()) {
				
				if (categoryValue.equals(Categories.ALL_CATEGORIES)) {
					continue;
				}
				
				categories.add(categoryValue.toString());
			}
			
			return categories;
		}
		
		categories.add(category);
		
		return categories;
	}

	private BiomobPlacesReturn toBiomobPlacesReturn(GoogleResponse googleResponse) {
		
		BiomobPlacesReturn biomobPlacesReturn = new BiomobPlacesReturn();
		
		for (GoogleResult result : googleResponse.getResults()) {
			Place place = new Place();
			place.setGoogleFields(result);
			
			place.setBiomobEvaluation(findBiomobEvaluation(result.getPlace_id()));
			
			biomobPlacesReturn.getPlaces().add(place);
		}
		
		biomobPlacesReturn.getPage().setActualPageUrl(googleResponse.getActualPageUrl());
		biomobPlacesReturn.getPage().setNextPageToken(googleResponse.getNext_page_token());
		
		return biomobPlacesReturn;
	}

	private List<Evaluation> findBiomobEvaluation(String place_id) {
		return evaluationRepository.findByPlaceId(place_id);
	}

}
