package com.udea.siiuseguimproyectosback.domain.entity.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_ROL_PARTICIPANTE_PROYECTO")
public class ProjectParticipantRol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENTIFICADOR", nullable = true, updatable = false)
	private Long id;

	@Size(max = 60)
	@Column(name = "NOMBRE", nullable = true)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "TIPO_PROYECTO", referencedColumnName = "IDENTIFICADOR", nullable = true)
	@NotFound(action = NotFoundAction.IGNORE)
	private ProjectType projectType;

//	@ManyToOne
//	private ProjectParticipant projectParticipant;

	@Column(name = "PARTICIPA_BENEFICIOS")
	private Integer benefitsParticipation;

	@Column(name = "APOYA_PROGRAMA_ACAD")
	private Integer academicProgramSupport;

	@Column(name = "TIPO_PROGRAMA_APOYADO")
	private String supportedProgramType;

	@Column(name = "DESCRIPCION")
	private String description;

	@Column(name = "INICIO_VIGENCIA")
	private Date startDate;

	@Column(name = "FIN_VIGENCIA")
	private Date endDate;

	@Column(name = "REGISTRADOR")
	private String recorder;

	@Column(name = "SELECTOR_REGISTRADOR")
	private String recorderSelector;

	@Column(name = "FECHA_ULTIMO_CAMBIO")
	private Date lastChangeDate;

	@Column(name = "ES_INVESTIGADOR_PRINCIPAL")
	private Integer isPrincipalInvestigator;

	@Column(name = "EXCLUSIVO_UDEA")
	private Integer exclusiveUdea;
}
