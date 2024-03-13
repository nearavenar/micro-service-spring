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
@Table(name="GENERO")
@Getter
@Setter
@ApiModel(description = "Información del Genero")
public class Genero {

	@Id
	@Column(name="ID_GENERO")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable del Genero")
	private Integer idGenero;
	
	@NotBlank(message="El nombre no puede estar vacio")
	@Column(name="NOMBRE", nullable = false, length = 50)
	@Size(min = 1, max = 50, message = "La descripción debe contener mínimo 1 caracteres y maximo 50")
	@ApiModelProperty(notes = "Nombre debe tener como minimo 1 caracteres y maximo 50", example = "Drama")
	private String nombre;
}
