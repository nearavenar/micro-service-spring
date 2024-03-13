package cl.aravena.microserviciosecurity.model;

import java.io.Serializable;

public class Rol implements Serializable{	
	private static final long serialVersionUID = 1295452251654759350L;
	
	private Long id;
	
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
}
