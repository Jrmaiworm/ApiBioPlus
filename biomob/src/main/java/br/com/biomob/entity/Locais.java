package br.com.biomob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "locais")
public class Locais {
	
	@Id
	@Column(name = "place_id")
	private String placeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "nota")
	private String nota;
	
	@Column(name = "haschairwheel")
	private Boolean haschairwheel;
	
	@Column(name = "hashandicappedhelp")
	private Boolean hashandicappedhelp;
	
	@Column(name = "hasinterpreter")
	private Boolean hasinterpreter;
	
	@Column(name = "hasspecialfurniture")
	private Boolean hasspecialfurniture;

	public boolean valid(Boolean field) {
		
		if (field == null) {
			return false;
		}
		
		return field;
	}

}
