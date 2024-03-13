package cl.aravena.microserviciocuenta.dto;

public class DetalleCompraDto {

	private Integer idCompra;
	
	private Integer idProducto;
	
	private Integer cantidad;
	
	private Integer valor;

	public DetalleCompraDto() {
		
	}
	
	public DetalleCompraDto(Integer idCompra, Integer idProducto, Integer cantidad, Integer valor) {
		super();
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.valor = valor;
	}

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
		return "DetalleCompraDto [idCompra=" + idCompra + ", idProducto=" + idProducto + ", cantidad=" + cantidad
				+ ", valor=" + valor + "]";
	}
}
