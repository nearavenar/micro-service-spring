package cl.aravena.microserviciocompra.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {
	
	@EmbeddedId
    private DetalleCompraPk id;
	
	@Column(nullable = false)
	private Integer cantidad;
	
	@Column(nullable = false)
	private Integer valor;

	public DetalleCompraPk getId() {
		return id;
	}

	public void setId(DetalleCompraPk id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DetalleCompra [id=" + id + ", cantidad=" + cantidad + ", valor=" + valor
				+ "]";
	}
}
