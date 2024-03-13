package com.aravena.arriendolibrosbackend.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.ForeignKey;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="LIBRO")
@Getter
@Setter
@ApiModel(description = "Información del Libro")
public class Libro {
	
	@Id
	@Column(name="ID_LIBRO")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable del Libro")
	private Integer idLibro;
	
	@NotBlank(message="El titulo no puede estar vacio")
	@Column(nullable = false, length = 50)
	@Size(min = 1, max = 50, message = "el nombre debe contener mínimo 1 caracteres y maximo 50")
	@ApiModelProperty(notes = "Titulo debe tener como minimo 1 caracteres y maximo 50", example = "Lenguaje Corporal")
	private String titulo;
	
	@Column(nullable = true, length = 500)
	@Size(min = 1, max = 500, message = "el nombre debe contener mínimo 1 caracteres y maximo 500")
	@ApiModelProperty(notes = "Descripcion debe tener como minimo 1 caracteres y maximo 500", example = "Libros de autoconocimiento")
    private String descripcion;
	
	@Column(name="FECHA_PUBLICACION")
	@JsonFormat(pattern="dd-MM-yyyy")
	@ApiModelProperty(notes = "Fecha de publicacion", example = "01-01-2021")
    private LocalDate fechaPublicacion;
    
	@Column(name="CANTIDAD_PAGINAS")
	@ApiModelProperty(notes = "La Cantidad de paginas debe contener", example = "150")
    private Integer cantidadPaginas;
    
    @Column(name="VALOR_DIARIO")
    @ApiModelProperty(notes = "Valor diario por arriendo", example = "1000")
    private Integer valorDiario;
    
    @Column(name="STOCK_DISPONIBLE")
    @ApiModelProperty(notes = "Stock del libro", example = "15")
    private Integer stockDisponible;
    
    @ManyToOne
    @JoinColumn(name="ID_EDITORIAL", nullable=false, foreignKey = @ForeignKey(name = "FK_ID_EDITORIAL"))
    private Editorial editorial;
    
    @ManyToOne
    @JoinColumn(name="ID_GENERO", nullable=false, foreignKey = @ForeignKey(name = "FK_ID_GENERO"))
    private Genero genero;
    
    @ManyToOne
    @JoinColumn(name="ID_AUTOR", nullable=false, foreignKey = @ForeignKey(name = "FK_ID_AUTOR"))
    private Autor autor;
    
    @ManyToOne
    @JoinColumn(name="ID_IDIOMA", nullable=false, foreignKey = @ForeignKey(name = "FK_ID_IDIOMA"))
    private Idioma idioma;
}
