package br.com.biomob.model;

import br.com.biomob.model.google.GoogleResult;
import lombok.Data;

@Data
public class Place {

	private GoogleResult googleFields = new GoogleResult();

	private BiomobFields biomobFields = new BiomobFields();

}
