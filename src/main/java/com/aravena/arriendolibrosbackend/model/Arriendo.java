package com.aravena.arriendolibrosbackend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ARRIENDO")
@Getter
@Setter
@ApiModel(description = "Información del Arriendo")
public class Arriendo {

	@Id
	@Column(name="ID_ARRIENDO")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable del Arriendo")
	private Integer idArriendo;
	
	@Column(name="FECHA_ARRIENDO")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@ApiModelProperty(notes = "Fecha del día que arrienda", example = "01-01-2021")
	private LocalDateTime fechaArriendo;
	
	@Column(name="FECHA_DESDE")
	@JsonFormat(pattern="dd-MM-yyyy")
	@ApiModelProperty(notes = "Fecha desde el comienzo del arriendo", example = "01-01-2021")
	private LocalDate fechaArriendoDesde;
	
	@Column(name="FECHA_HASTA")
	@JsonFormat(pattern="dd-MM-yyyy")
	@ApiModelProperty(notes = "Fecha de entrega del libro del arriendo", example = "01-02-2021")
	private LocalDate fechaArriendoHasta;
	
	@ManyToOne
    @JoinColumn(name="ID_LIBRO", nullable=false, foreignKey = @ForeignKey(name = "ID_LIBRO"))
	@ApiModelProperty(notes = "Libro que arrienda")
    private Libro libro;
	
	@ManyToOne
    @JoinColumn(name="ID_USUARIO", nullable=false, foreignKey = @ForeignKey(name = "ID_USUARIO"))
	@ApiModelProperty(notes = "Usuario que arrienda")
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name="ID_ESTADO_ARRIENDO", nullable=false, foreignKey = @ForeignKey(name = "ID_ESTADO_ARRIENDO"))
	@ApiModelProperty(notes = "Estado en que se encuentra el arriendo")
	private EstadoArriendo estadoArriendo;
}
