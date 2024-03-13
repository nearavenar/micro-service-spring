package cl.aravena.microservicioproducto.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Proveedor implements Serializable{

	@Id
	@Column(nullable = false)
	private Integer rut;
	
	@Column(nullable = false)
	private char dv;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	private String direccion;
	
	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public char getDv() {
		return dv;
	}

	public void setDv(char dv) {
		this.dv = dv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Proveedor [rut=" + rut + ", dv=" + dv + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + "]";
	}

	private static final long serialVersionUID = 1331235512653008352L;
}
