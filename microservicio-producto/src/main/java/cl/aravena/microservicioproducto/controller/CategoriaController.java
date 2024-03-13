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

import cl.aravena.microservicioproducto.models.Categoria;
import cl.aravena.microservicioproducto.service.CategoriaService;

@RestController
//@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/buscaTodasCategorias")
	public List<Categoria> findAll(){
		return categoriaService.findAll();
	}
	
	@GetMapping("/buscarCategoriaPorId/{id}")
	public Categoria findById(@PathVariable("id") Integer id) {
		Categoria producto = categoriaService.findById(id);
		return producto;
	}
	
	@PostMapping("/crearCategoria")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria save(@RequestBody Categoria producto){
		return categoriaService.save(producto);
	}
	
	@PutMapping("/actualizarCategoria")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria update(@RequestBody Categoria producto){
		return categoriaService.update(producto);
	}
	
	@DeleteMapping("/eliminaCategoriaPorId/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		categoriaService.deleteById(id);
	}
}
