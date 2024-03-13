package com.aravena.arriendolibrosbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleArriendoDTO {

	@ApiModelProperty(notes = "id cuando se genero el arriendo", example = "1")
	private Integer idArriendo;
	
	@ApiModelProperty(notes = "Titulo del libro", example = "Los Detectives Salvajes")
	private String tituloLibro;
	
	@ApiModelProperty(notes = "Fecha de publicacion", example = "01-10-1963")
	private String fechaPublicacion;
	
	@ApiModelProperty(notes = "Descripcion", example = "Detecives")
	private String descripcion;
	
	@ApiModelProperty(notes = "Editorial", example = "Cuatro Vientos")
	private String editorial;
	
	@ApiModelProperty(notes = "Genero", example = "Aventuras")
	private String genero;
	
	@ApiModelProperty(notes = "Autor", example = "Roberto Bolaño")
	private String autor;
	
	@ApiModelProperty(notes = "Idioma", example = "Español")
	private String idioma;
	
	@ApiModelProperty(notes = "Cantidad de paginas", example = "123")
	private Integer paginas;
	
	@ApiModelProperty(notes = "Valor arriendo por dia", example = "500")
	private Integer valorDiario;
	
	@ApiModelProperty(notes = "Fecha que realizo el arriendo", example = "17-05-2021")
	private String fechaArriendo;
	
	@ApiModelProperty(notes = "Fecha inicio de arriendo de libro", example = "17-05-2021")
	private String fechaDesde;
	
	@ApiModelProperty(notes = "Fecha entega de arriendo de libro", example = "28-05-2021")
	private String fechaHasta;
	
	@ApiModelProperty(notes = "Diferencia dias (fechaHasta-fechaDesde)", example = "11")
	private Integer diasArriendo;
	
	@ApiModelProperty(notes = "Valor de (diasArriendo * valorDiario)", example = "5500")
	@JsonFormat(shape=Shape.STRING, pattern="###,###.##")
	private String valorTotal;
	
	@ApiModelProperty(notes = "Estado del arriendo de libro", example = "ARRENDADO")
	private String estado;
	
	@ApiModelProperty(notes = "Nombre completo de usuario", example = "Nicolás Aravena")
	private String nombreUsuario;
	
	@ApiModelProperty(notes = "Email de usuario", example = "nicolas.aravena25@gmail.com")
	private String email;
	
	@ApiModelProperty(notes = "direccion de usuario", example = "Mi calle 1")
	private String direccion;
	
	@ApiModelProperty(notes = "telefono de usuario", example = "987654321")
	private String telefono;
}
