package com.udea.siiuseguimproyectosback.domain.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RESEARCH_GROUP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResearchGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENTIFICADOR")
	private Long id;

	@Column(name = "NOMBRE_COMPLETO", length = 200)
	private String fullName;

	@Column(name = "NOMBRE_CORTO", length = 60)
	private String shortName;

	@Column(name = "CODIGO_COLCIENCIAS", length = 18)
	private String colcienciasCode;

	@Column(name = "AREA_INVESTIGACION")
	private Integer researchArea;

	@Column(name = "UBICACION_FISICA", length = 100)
	private String physicalLocation;

	@Column(name = "UBICACION_EN_SEDE", length = 50)
	private String siteLocation;

	@Column(name = "TELEFONO", length = 30)
	private String phone;

	@Column(name = "CORREO_ELECTRONICO", length = 100)
	private String email;

	@Column(name = "SITIO_WEB", length = 200)
	private String website;

	@Column(name = "ESTADO", length = 20)
	private String status;

	@Column(name = "TIPO", length = 20)
	private String type;

	@Column(name = "CLASIFICACION_COLCIENCIAS", length = 5)
	private String colcienciasClassification;

	@Column(name = "ANO_CREACION")
	private Integer creationYear;

	@Column(name = "OBJETIVO_GENERAL", length = 4000)
	private String generalObjective;

	@Column(name = "MISION", length = 4000)
	private String mission;

	@Column(name = "FAX", length = 30)
	private String fax;

	@Column(name = "AREA_CONOCIMIENTO")
	private Integer knowledgeArea;

	@Column(name = "NUMERO_ENTIDADES_VINCULADAS")
	private Integer linkedEntitiesNumber;

	@Column(name = "NUMERO_ENTIDADES_AVALAN")
	private Integer endorsedEntitiesNumber;

	@Column(name = "VIGENCIA_TRIMESTRE_REPORTADO")
	private Integer reportedYearQuarter;

	@Column(name = "TRIMESTRE_REPORTADO")
	private Integer reportedQuarter;

	@Column(name = "NRO_ID_GRUPO", length = 14)
	private String groupId;

	@Column(name = "CORPORACIONYSIU")
	private Integer corporationYsiu;

	@Column(name = "ASOCIADOALSIU", length = 2)
	private String associatedToSiu;

	@Column(name = "ODS_PRINCIPAL")
	private Integer mainOds;

	@Column(name = "AREA_OCDE")
	private Long oecdArea;

	@Column(name = "SUBAREA_OCDE")
	private Long oecdSubarea;
}
