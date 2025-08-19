package com.udea.siiuseguimproyectosback.domain.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_SUBNIVEL_PROYECTO")
public class ProjectSubLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBNIVEL_PROYECTO", nullable = true, updatable = false)
	private Long subLevelProject;

	@Column(name = "IDENTIFICADOR", nullable = true)
	private Long id;

	@Size(max = 50)
	@Column(name = "NOMBRE", nullable = true)
	private String name;

	@Size(max = 500)
	@Column(name = "DESCRIPCION", nullable = true)
	private String description;

	@Size(max = 20)
	@Column(name = "TIPONIVEL", nullable = true)
	private String levelType;

	@Column(name = "LISTAR_CON_NIVELES", nullable = true)
	private Integer listWithLevels;
}
