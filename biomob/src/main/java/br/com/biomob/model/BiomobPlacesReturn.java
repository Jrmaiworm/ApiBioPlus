package br.com.biomob.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BiomobPlacesReturn {
	
	private Page page = new Page();
	
	private List<Place> places = new ArrayList<>();
	
}
