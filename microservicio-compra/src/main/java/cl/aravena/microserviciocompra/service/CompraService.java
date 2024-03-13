package cl.aravena.microserviciocompra.service;

import java.util.List;

import cl.aravena.microserviciocompra.dto.CompraDto;
import cl.aravena.microserviciocompra.models.Compra;

public interface CompraService {

	public List<Compra> findAllCompra();
	public Compra findByIdCompra(Integer id);
	public Compra saveCompra(Compra p);
	public Compra updateCompra(Compra p);
	public void deleteByIdCompra(Integer id);
	
	public CompraDto saveCompra(CompraDto p);
	public CompraDto updateCompra(CompraDto p);
}
