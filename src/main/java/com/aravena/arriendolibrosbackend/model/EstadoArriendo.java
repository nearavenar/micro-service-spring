package com.aravena.arriendolibrosbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ESTADO_ARRIENDO")
@Getter
@Setter
@ApiModel(description = "Información del Estado del Arriendo")
public class EstadoArriendo {

	@Id
	@Column(name="ID_ESTADO_ARRIENDO")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable del Estado del Arriendo")
	private Integer idEstadoArriendo;
	
	@Column(name="DESCRIPCION", nullable = false, length = 15)
	@Size(min = 3, max = 20, message = "El estado debe contener mínimo 3 caracteres y maximo 20")
	@ApiModelProperty(notes = "El estado en el que se encuentra el arriendo")
	private String descripcion;
}
