package com.aravena.arriendolibrosbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ROL")
@Getter
@Setter
public class Rol {

	@Id
	@Column(name="ID_ROL")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable del Rol")
	private Integer idRol;
	
	@NotBlank(message="La descripción no puede estar vacio")
	@Column(name="DESCRIPCION", nullable = false, length = 30)
	@Size(min = 1, max = 30, message = "el nombre debe contener mínimo 1 caracteres y maximo 30")
	@ApiModelProperty(notes = "descripción del rol", example = "Usuario")
	private String descripcion;
}
