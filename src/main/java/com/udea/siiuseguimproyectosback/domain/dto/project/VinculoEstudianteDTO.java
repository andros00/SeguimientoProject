package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

@Data
public class VinculoEstudianteDTO {
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
