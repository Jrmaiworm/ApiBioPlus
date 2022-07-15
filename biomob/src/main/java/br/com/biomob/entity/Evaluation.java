package br.com.biomob.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.biomob.model.evaluation.ValuesType;
import lombok.Data;

@Data
@Entity
@Table(name = "biomob_plus_evaluator")
public class Evaluation {
	
	@Id
	@Column(name = "evaluation_id")
	private String evaluationId; //id da avaliacao
	
	@Column(name = "place_id")
	private String placeId; //id do lugar (google)
	
	@Column(name = "place_name")
	private String placeName; //nome do lugar
	
	@Column(name = "user_id")
	private String userId; //id do usuario biomob plus
	
	@Column(name = "user_name")
	private String userName; //nome do usuario biomob plus
	
	@Column(name = "internal_circulation")
	@Enumerated(EnumType.STRING)
	private ValuesType internalCirculation; //circulacão interna - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	@Column(name = "parking")
	@Enumerated(EnumType.STRING)
	private ValuesType parking; //estacionamento - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	@Column(name = "sidewalk")
	@Enumerated(EnumType.STRING)
	private ValuesType sidewalk; //calcada - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	@Column(name = "audio_visual")
	@Enumerated(EnumType.STRING)
	private ValuesType audioVisual; //audio/visual - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	@Column(name = "main_entrance")
	@Enumerated(EnumType.STRING)
	private ValuesType mainEntrance; //entrada principal - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	@Column(name = "accessible_bathroom")
	@Enumerated(EnumType.STRING)
	private ValuesType accessibleBathroom; //banheiro acessivel - Resultados possiveis: YES | NO | NOT_APPLICABLE | NONE
	
	@Column(name = "wheelchair_access")
	private Boolean wheelchairAccess; //acesso cadeira de rodas - Resultados possiveis: true | false
	
	@Column(name = "braille_menu")
	private Boolean brailleMenu; //cardapio braile - Resultados possiveis: true | false
	
	@Column(name = "service_in_libras")
	private Boolean serviceInLibras; //atendimento em libras - Resultados possiveis: true | false
	
	@Column(name = "audio_menu")
	private Boolean audioMenu; //cardapio com audio - Resultados possiveis: true | false
	
	@Column(name = "star")
	private String star; //nota
	
}
