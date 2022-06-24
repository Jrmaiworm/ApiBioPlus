package br.com.biomob.model.google;

import java.util.List;

import lombok.Data;

@Data
public class GoogleResponse {
	
	private String actualPageUrl;
	
	private String next_page_token;
	
	private List<GoogleResult> results;

}
