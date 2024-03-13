package cl.aravena.microserviciocuenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aravena.microserviciocuenta.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{	
	public Usuario findByUsername(String usuario);
}
