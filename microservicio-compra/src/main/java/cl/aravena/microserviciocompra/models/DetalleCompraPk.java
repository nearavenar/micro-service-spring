package cl.aravena.microserviciocompra.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DetalleCompraPk implements Serializable{	

	private Integer idCompra;

	private Integer idProducto;
	
	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	@Override
	public String toString() {
		return "DetalleCompraPk [idCompra=" + idCompra + ", idProducto=" + idProducto + "]";
	}

	private static final long serialVersionUID = -269663640586894116L;
}