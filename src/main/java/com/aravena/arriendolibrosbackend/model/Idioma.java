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
@Table(name="IDIOMA")
@Getter
@Setter
@ApiModel(description = "Información del Idioma")
public class Idioma {

	@Id
	@Column(name="ID_IDIOMA")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable del Idioma")
	private Integer idIdioma;
	
	@NotBlank(message="La descripcion no puede estar vacio")
	@Column(name="DESCRIPCION", nullable = true, length = 50)
	@Size(min = 1, max = 50, message = "La descripción debe contener mínimo 1 caracteres y maximo 50")
	@ApiModelProperty(notes = "descripción debe tener como minimo 1 caracteres y maximo 50", example = "Chino Mandarín")
	private String descripcion;
}
