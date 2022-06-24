package br.com.biomob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.biomob.config.ConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class BiomobApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiomobApplication.class, args);
	}

}
