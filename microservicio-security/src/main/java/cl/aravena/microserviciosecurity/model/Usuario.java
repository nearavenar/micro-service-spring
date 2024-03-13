package cl.aravena.microserviciosecurity.model;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 7700451325948143378L;

	private Long id;

	private String username;

	private String password;

	private String nombre;

	private String apellido;

	private String email;

	private Boolean enabled;

	private Integer intentos;

	private List<Rol> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setNombreUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", nombre="
				+ nombre + ", apellido=" + apellido + ", email=" + email + ", enabled=" + enabled + ", intentos="
				+ intentos + ", roles=" + roles + "]";
	}
}
