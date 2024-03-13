package cl.aravena.microservicioproducto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.aravena.microservicioproducto.models.Proveedor;
import cl.aravena.microservicioproducto.service.ProveedorService;

@RestController
//@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/buscaTodosProveedor")
	public List<Proveedor> findAll(){
		return proveedorService.findAll();
	}
	
	@GetMapping("/buscarProveedorPorId/{id}")
	public Proveedor findById(@PathVariable("id") Integer id) {
		Proveedor producto = proveedorService.findById(id);
		return producto;
	}
	
	@PostMapping("/crearProveedor")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor save(@RequestBody Proveedor producto){
		return proveedorService.save(producto);
	}
	
	@PutMapping("/actualizarProveedor")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor update(@RequestBody Proveedor producto){
		return proveedorService.update(producto);
	}
	
	@DeleteMapping("/eliminaProveedorPorId/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		proveedorService.deleteById(id);
	}
}
