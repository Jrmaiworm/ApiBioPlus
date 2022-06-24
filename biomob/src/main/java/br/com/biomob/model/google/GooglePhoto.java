package br.com.biomob.model.google;

import java.util.List;

import lombok.Data;

@Data
public class GooglePhoto {
	
	private String height;
	
	private List<String> html_attributions;
	
	private String photo_reference;
	
	private String width;

}
