package cl.aravena.microserviciosecurity.services;


import cl.aravena.microserviciosecurity.model.Usuario;

public interface UsuarioService {

	public Usuario findByUserName(String username);
	public Usuario update(Usuario usuario);
}
