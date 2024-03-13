package cl.aravena.microserviciocuenta.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cl.aravena.microserviciocuenta.models.Usuario;
import cl.aravena.microserviciocuenta.service.UsuarioService;

import cl.aravena.microserviciocuenta.dto.CompraDto;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/buscaTodosUsuarios")
	public List<Usuario> findAll(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/buscarUsuarioPorId/{id}")
	public Usuario findById(@PathVariable("id") Integer id) {
		Usuario producto = usuarioService.findById(id);
		return producto;
	}
	
	
	@GetMapping("/buscarUsuarioPorNombre")
	public Usuario findByUserName(@RequestParam("usuario") String usuario){
		Usuario producto = usuarioService.findByUserName(usuario);
		return producto;
	}
	
	@PostMapping("/crearUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody Usuario producto){
		return usuarioService.save(producto);
	}
	
	@PutMapping("/actualizarUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario producto){
		return usuarioService.update(producto);
	}
	
	@DeleteMapping("/eliminaUsuarioPorId/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		usuarioService.deleteById(id);
	}
	
	@HystrixCommand(fallbackMethod = "findDetalleCompraByIdUserAlternativo")
	@GetMapping("/detalleCompraPorIdUsuario/{idUser}")
	public List<CompraDto> findDetalleCompraByIdUser(@PathVariable("idUser") Integer idUser) {
		/*Probare el metodo alternativo creando un error
		int pruebametodoAlternativo = Integer.parseInt("Hola");*/
		List<CompraDto> compraDto = usuarioService.findDetalleCompraByIdUser(idUser);
		return compraDto;
	}
	
	public List<CompraDto> findDetalleCompraByIdUserAlternativo(@PathVariable("idUser") Integer idUser) {
		System.out.println("************ Soy el metodo alternativo findDetalleCompraByIdUserAlternativo *****************");
		return usuarioService.findDetalleCompraByIdUserAlternativo(idUser);
	}
	
	@GetMapping("/detalleCompraPorId/{idCompra}/{idUser}")
	public CompraDto findDetalleCompraByIdCompraAndIdUser(@PathVariable("idCompra") Integer id
			                                             ,@PathVariable("idUser") Integer idUser) {
		return usuarioService.findDetalleCompraByIdCompraAndIdUser(id, idUser);
	}
}
