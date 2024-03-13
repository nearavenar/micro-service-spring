package com.aravena.arriendolibrosbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EDITORIAL")
@Getter
@Setter
@ApiModel(description = "Información de la Editorial")
public class Editorial {

	@Id
	@Column(name="ID_EDITORIAL")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable de la Editorial")
	private Integer idEditorial;
	
	@NotBlank(message="El nombre no puede estar vacio")
	@Column(name="NOMBRE", nullable = false, length = 100)
	@Size(min = 1, max = 100, message = "el nombre debe contener mínimo 1 caracteres y maximo 100")
	@ApiModelProperty(notes = "Nombre debe tener como minimo 1 caracteres y maximo 100")
	private String nombre;
}
