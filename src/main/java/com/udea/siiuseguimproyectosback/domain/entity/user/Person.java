package com.udea.siiuseguimproyectosback.domain.entity.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_PERSONA_NATURAL")
public class Person {

	@Id
	@Size(max = 20)
	@Column(name = "IDENTIFICACION", nullable = false)
	private String id;

	@Size(max = 30)
	@Column(name = "TIPO_IDENTIFICACION")
	private String identificationType;

	@Size(max = 100)
	@Column(name = "NOMBRE_PILA")
	private String firstName;

	@Size(max = 100)
	@Column(name = "APELLIDO1")
	private String lastName1;

	@Size(max = 100)
	@Column(name = "APELLIDO2")
	private String lastName2;

	@Size(max = 250)
	@Column(name = "CORREO_ELECTRONICO")
	private String email;

	@Size(max = 200)
	@Column(name = "DIRECCION")
	private String address;

	@Size(max = 30)
	@Column(name = "TELEFONO")
	private String phone;

	@Size(max = 100)
	@Column(name = "IDENTIFICACION_LDAP")
	private String ldapIdentification;

	@Size(max = 30)
	@Column(name = "FAX")
	private String fax;

	@Column(name = "CONTINENTE")
	private Integer continent;

	@Column(name = "PAIS")
	private Integer country;

	@Column(name = "DEPARTAMENTO")
	private Integer department;

	@Column(name = "MUNICIPIO")
	private Integer municipality;

	@Column(name = "TEMPORAL")
	private Integer temporary;

	@Column(name = "FECHA_NACIMIENTO")
	private Date birthDate;

	@Column(name = "SEXO")
	private String gender;

	@Column(name = "ACTIVO")
	private Integer active;
}
