package com.aravena.arriendolibrosbackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@ApiModel(description = "Información del Usuario")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario {

	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id autoincrementable del Usuario"/*, position = 0*/)
	private Integer idUsuario;

	@Column(name="USUARIO", nullable = false, length = 15, unique=true)
	@Size(min = 5, max = 15, message = "El usuario debe contener mínimo 5 caracteres y maximo 15")
	@ApiModelProperty(notes = "usuario debe tener como minimo 5 caracteres y maximo 15", example = "naravenar", required = true)
	private String usuario;
	
	@Column(name="NOMBRES", nullable = false, length = 50)
	@Size(min = 1, max = 50, message = "El nombre debe contener mínimo 1 caracteres y maximo 50")
	@ApiModelProperty(notes = "nombre debe tener como minimo 1 caracteres y maximo 50", example = "Nicolas", required = true)
	private String nombre;
	
	@Column(name="APELLIDOS", nullable = false, length = 50)
	@Size(min = 1, max = 50, message = "El apellido debe contener mínimo 1 caracteres y maximo 50")
	@ApiModelProperty(notes = "apellido debe tener como minimo 1 caracteres y maximo 50", example = "Aravena")
	private String apellido;

	@Column(name="PASSWORD", nullable = false, length = 100)
	@Size(min = 1, max = 100, message = "El password debe contener mínimo 1 caracteres y maximo 100")
	@ApiModelProperty(notes = "password debe tener como minimo 1 caracteres y maximo 100", example = "nico")
	private String password;
	
	@Column(name="DIRECCION", nullable = false, length = 80)
	@Size(min = 5, max = 80, message = "La direccion debe contener mínimo 5 caracteres y maximo 80")
	@ApiModelProperty(notes = "direccion debe tener como minimo 5 caracteres y maximo 80", example = "Mi casa")
	private String direccion;
	
	@Email
	@Column(name="EMAIL", nullable = false, length = 50)
	@Size(min = 1, max = 50, message = "El email debe contener mínimo 1 caracteres y maximo 50")
	@ApiModelProperty(notes = "email debe tener como minimo 1 caracteres y maximo 50", example = "nicolas@gmail.com")
	private String email;
	
	@Column(name="TELEFONO", nullable = false, length = 12)
	@Size(min = 1, max = 12, message = "El telefono debe contener mínimo 1 caracteres y maximo 12")
	@ApiModelProperty(notes = "telefono debe tener como minimo 1 caracteres y maximo 12", example = "987654321")
	private String telefono;

	@Column(name = "ESTADO", nullable = false, length = 1)
	@ApiModelProperty(notes = "estado (1 = ACTIVO o 0 = INACTIVO)", example = "1")
	private Integer estado;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USUARIO_ROL"
	         , joinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
	         , inverseJoinColumns = @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL"))
	private List<Rol> roles;
}
