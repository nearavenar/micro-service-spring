package cl.aravena.microserviciocompra.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_compra", nullable = false)
	private Integer idCompra;
	
	@Column(name="id_usuario", nullable = false)
	private Integer idUsuario;
	
	private LocalDate fecha;
	
	@Column(name="total")
	private Integer totalCompra;

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Integer totalCompra) {
		this.totalCompra = totalCompra;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", idUsuario=" + idUsuario + ", fecha=" + fecha + ", totalCompra="
				+ totalCompra + "]";
	}
}
