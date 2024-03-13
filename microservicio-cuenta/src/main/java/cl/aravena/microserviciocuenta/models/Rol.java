package cl.aravena.microserviciocuenta.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol implements Serializable{	
	private static final long serialVersionUID = 1295452251654759350L;
	
	@Id
	@Column(name="id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	
	@Column(unique = true, length = 30)
	private String nombre;

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombre=" + nombre + "]";
	}
}
