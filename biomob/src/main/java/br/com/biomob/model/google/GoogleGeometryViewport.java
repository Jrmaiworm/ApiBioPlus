package br.com.biomob.model.google;

import lombok.Data;

@Data
public class GoogleGeometryViewport {
	
	private GoogleGeometryViewportNortheast northeast;
	
	private GoogleGeometryViewportSouthwest southwest;

}
