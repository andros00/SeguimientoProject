package com.udea.siiuseguimproyectosback.domain.entity.project;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VinculoEstudiante {
	
	@Id
	private String identificacion;
	private String selectorPersona;
	private String codigoFacultad;
	private String nombreFacultad;
	private String codigoPrograma;
	private String nombrePrograma;
	private String codigoTipo;
	private String nombreTipoPrograma;
	private Double porcentajeCompletado;

}
