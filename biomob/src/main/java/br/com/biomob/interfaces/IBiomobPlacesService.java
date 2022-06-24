package br.com.biomob.interfaces;

import br.com.biomob.model.BiomobPlacesReturn;

public interface IBiomobPlacesService {
	
	BiomobPlacesReturn findPlacesByGeoreference(String category, String latitude, String longitude, String range);
	
	BiomobPlacesReturn nextPage(String actualPage, String nextPageToken);
	
}
