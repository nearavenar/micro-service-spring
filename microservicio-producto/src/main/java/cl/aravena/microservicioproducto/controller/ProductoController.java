package cl.aravena.microservicioproducto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.aravena.microservicioproducto.models.Producto;
import cl.aravena.microservicioproducto.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/buscaTodosProductos")
	public List<Producto> findAll(){
		return productoService.findAll();
	}
	
	@GetMapping("/buscarProductoPorId/{id}")
	public Producto findById(@PathVariable("id") Integer id) {
		Producto producto = productoService.findById(id);
		return producto;
	}
	
	@PostMapping("/crearProducto")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto save(@RequestBody Producto producto){
		return productoService.save(producto);
	}
	
	@PutMapping("/actualizarProducto")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto){
		return productoService.update(producto);
	}
	
	@DeleteMapping("/eliminaProductoPorId/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		productoService.deleteById(id);
	}
}
