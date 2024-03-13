package com.aravena.arriendolibrosbackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aravena.arriendolibrosbackend.model.Rol;
import com.aravena.arriendolibrosbackend.repository.RolRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RolTest {

	@Autowired
    private RolRepository rolRepository;
	
	@Test
	public void obtenerRoles() {
		List<Rol> listaRoles = rolRepository.findAll();
		assertFalse(listaRoles.isEmpty());
	}
	
	@Test
	public void validar_rol_existe() {
		Rol rolAdmin = rolRepository.findOneByDescripcion("ADMINISTRADOR");
		assertEquals(rolAdmin.getIdRol().intValue(), 1);
	}
}
