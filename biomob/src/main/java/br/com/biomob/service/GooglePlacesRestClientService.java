package br.com.biomob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.biomob.config.ConfigProperties;
import br.com.biomob.interfaces.IGooglePlacesRestClientService;
import br.com.biomob.model.google.GoogleResponse;

@Service
public class GooglePlacesRestClientService implements IGooglePlacesRestClientService {
	
	private static final String NEXT_PAGE_URL_KEY = "&pagetoken=";
	
	@Autowired
	ConfigProperties prop;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public GoogleResponse findPlaces(String category, String latitude, String longitude, String range) {
		String url = String.format(prop.getGoogleFindByGeoUrl(), category, latitude, longitude, range, prop.getGoogleLocation(), prop.getGoogleApiKey());
		return request(url);
	}
	
	@Override
	public GoogleResponse nextPage(String actualPageUrl, String nextPageToken) {
		String url = actualPageUrl.replaceAll(NEXT_PAGE_URL_KEY + ".*", "") + NEXT_PAGE_URL_KEY + nextPageToken;
		return request(url);
	}
	
	private GoogleResponse request(String url) {
		GoogleResponse googleResponse = restTemplate.getForEntity(url, GoogleResponse.class).getBody();
		googleResponse.setActualPageUrl(url);
		return googleResponse;
	}
	
}
