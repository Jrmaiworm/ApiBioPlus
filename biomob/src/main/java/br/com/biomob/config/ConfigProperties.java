package br.com.biomob.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("app")
public class ConfigProperties {
	
	private String googleLocation;
	
	private String googleApiKey;
	
	private String googleFindByGeoUrl;
	
}
