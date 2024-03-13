package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aravena.arriendolibrosbackend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findOneByUsuario(String usuario);
	Usuario findOneByIdUsuario(int idUsuario);
}
