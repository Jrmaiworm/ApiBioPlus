package br.com.biomob.model.google;

import java.util.List;

import lombok.Data;

@Data
public class GoogleResult {
	
	private String business_status;
	
	private String formatted_address;
	
	private GoogleGeometry geometry;
	
	private String icon;
	
	private String icon_background_color;
	
	private String icon_mask_base_uri;
	
	private String name;
	
	private GoogleOpeningHours opening_hours;
	
	private List<GooglePhoto> photos;
	
	private String place_id;
	
	private GooglePlusCode plus_code;
	
	private String rating;
	
	private String reference;
	
	private List<String> types;
	
	private String user_ratings_total;

}
