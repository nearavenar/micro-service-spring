package com.aravena.arriendolibrosbackend.model;

import java.io.Serializable;

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
@Table(name="AUTOR")
@Getter
@Setter
@ApiModel(description = "Información del Autor")
public class Autor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AUTOR")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable del Autor")
	private Integer idAutor;
	
	@NotBlank(message="El nombre no puede estar vacio")
	@Column(name="NOMBRE", nullable = true, length = 100)
	@ApiModelProperty(notes = "Nombre debe tener como minimo 3 caracteres y maximo 100", example = "Pablo Rios")
    @Size(min = 3, max = 50, message = "El nombre debe contener mínimo 3 caracteres y maximo 100")
	private String nombre;
}
