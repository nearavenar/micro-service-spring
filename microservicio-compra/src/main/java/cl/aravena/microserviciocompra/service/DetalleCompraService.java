package cl.aravena.microserviciocompra.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.aravena.microserviciocompra.dto.CompraDto;
import cl.aravena.microserviciocompra.dto.ProductoDto;
import cl.aravena.microserviciocompra.models.DetalleCompra;

@Repository
public interface DetalleCompraService {

	public List<DetalleCompra> findAllDetalleCompra();
	public DetalleCompra findByIdDetalleCompra(Integer id);
	public DetalleCompra saveDetalleCompra(DetalleCompra d);
	public DetalleCompra updateDetalleCompra(DetalleCompra d);
	public void deleteByIdDetalleCompra(Integer id);
	public CompraDto findDetalleCompraByIdCompraAndIdUser(Integer idCompra, Integer idUser);
	public List<CompraDto> findDetalleCompraByIdUser(Integer idUser);
	
	public List<ProductoDto> findAllProductos();
	public ProductoDto findByIdProducto(Integer id);
}
