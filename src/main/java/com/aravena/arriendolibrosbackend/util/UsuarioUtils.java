package com.aravena.arriendolibrosbackend.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aravena.arriendolibrosbackend.model.Usuario;
import com.aravena.arriendolibrosbackend.service.UsuarioService;

/*Usare esta clase para actualizar la contraseña de los usuarios  de prueba que creo en el import.sql (encriptandola)*/
@Component
public class UsuarioUtils  implements CommandLineRunner {

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Usuario> listaUsuarios =  usuarioService.findAll();
		
		listaUsuarios.forEach(x -> {
			usuarioService.update(x);
		});
	}
}

