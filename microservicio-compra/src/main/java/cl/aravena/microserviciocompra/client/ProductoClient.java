package cl.aravena.microserviciocompra.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.aravena.microserviciocompra.dto.ProductoDto;

@FeignClient(name="servicio-producto")
public interface ProductoClient {

	@GetMapping("/buscarProductoPorId/{id}")
	public ProductoDto findById(@PathVariable("id") Integer id);
	
	@GetMapping("/buscaTodosProductos")
	public List<ProductoDto> findAll();
}
