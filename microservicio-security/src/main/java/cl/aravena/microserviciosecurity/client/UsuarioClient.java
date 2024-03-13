package cl.aravena.microserviciosecurity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cl.aravena.microserviciosecurity.model.Usuario;

@FeignClient("servicio-cuenta")
public interface UsuarioClient {

	@GetMapping("/buscarUsuarioPorNombre")
	public Usuario findByUserName(@RequestParam("usuario")  String usuario);
	
	@PutMapping()
	public Usuario update(@RequestBody Usuario usuario);
}
