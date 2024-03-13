package cl.aravena.microserviciocompra.dto;

public class ProveedorDto {

	private Integer rut;
	private char dv;
	private String nombre;
	private String telefono;
	private String direccion;
	
	public ProveedorDto() {
		
	}
	
	public ProveedorDto(Integer rut, char dv, String nombre, String telefono, String direccion) {
		super();
		this.rut = rut;
		this.dv = dv;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
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
		return "ProveedorDto [rut=" + rut + ", dv=" + dv + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}
}
