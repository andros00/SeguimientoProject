package com.udea.siiuseguimproyectosback.domain.entity.project;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_PROYECTO_DETALLE")
public class ProjectIFormal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private Long id;

	@Column(name = "CODIGO_PROYECTO", length = 20, nullable = false)
	private String projectCode;

	@Column(name = "DURACION")
	private Long duration;

	@Column(name = "FECHA_INICIO")
	private Timestamp startDate;

	@Column(name = "FECHA_FINALIZACION")
	private Timestamp endDate;

	@Column(name = "NOTIFICADO_IF", length = 1)
	private String notifiedIf;

	@Column(name = "NOTIFICADO_FF", length = 1)
	private String notifiedFf;

	@Column(name = "NOTIFICADO_PA", length = 1)
	private String notifiedPa;

	@Column(name = "NOTIFICADO_AR", length = 1)
	private String notifiedAr;

	@Column(name = "NOTIFICADO_FECHA_PE")
	private Timestamp notifiedDatePe;

	@Column(name = "NOTIFICADO_FECHA_TE")
	private Timestamp notifiedDateTe;

	@Column(name = "USUARIO_CREA", length = 20)
	private String userCreate;

	@Column(name = "FECHA_CREA")
	private Timestamp dateCreate;

	@Column(name = "USUARIO_MODIFICA", length = 20)
	private String userModify;

	@Column(name = "FECHA_MODIFICA")
	private Timestamp dateModify;

	@Column(name = "CODIGO_INTERNO", length = 20)
	private String internalCode;

	@Column(name = "ESTADO", length = 20)
	private String status;

	@Column(name = "CODIGO_APROB_ACTA_CODI", length = 20)
	private String approvalCode;

	@Column(name = "FECHA_APROB_PROY_CODI")
	private Date approvalDate;
}
