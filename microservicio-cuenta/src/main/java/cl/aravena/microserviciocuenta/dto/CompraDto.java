package cl.aravena.microserviciocuenta.dto;

import java.time.LocalDate;
import java.util.List;

public class CompraDto {
	
	private Integer idCompra;
	
	private Integer idUsuario;
	
	private LocalDate fecha;
	
	private Integer totalCompra;
	
	private List<DetalleCompraDto> detalleCompraDto;
	
	public CompraDto() {
		
	}

	public CompraDto(Integer idCompra, Integer idUsuario, LocalDate fecha, Integer totalCompra,
			List<DetalleCompraDto> detalleCompraDto) {
		super();
		this.idCompra = idCompra;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.totalCompra = totalCompra;
		this.detalleCompraDto = detalleCompraDto;
	}

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

	public List<DetalleCompraDto> getDetalleCompraDto() {
		return detalleCompraDto;
	}

	public void setDetalleCompraDto(List<DetalleCompraDto> detalleCompraDto) {
		this.detalleCompraDto = detalleCompraDto;
	}

	@Override
	public String toString() {
		return "CompraDto [idCompra=" + idCompra + ", idUsuario=" + idUsuario + ", fecha=" + fecha + ", totalCompra="
				+ totalCompra + ", detalleCompraDto=" + detalleCompraDto + "]";
	}
}
