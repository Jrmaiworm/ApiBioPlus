package br.com.biomob.interfaces;

import br.com.biomob.model.google.GoogleResponse;

public interface IGooglePlacesRestClientService {
	
	GoogleResponse findPlaces(String category, String latitude, String longitude, String range);
	
	GoogleResponse nextPage(String actualPage, String nextPageToken);
	
}
