package com.aravena.arriendolibrosbackend.servicesImpl;

import com.aravena.arriendolibrosbackend.service.RolService;
import com.aravena.arriendolibrosbackend.util.Utils;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aravena.arriendolibrosbackend.model.Rol;
import com.aravena.arriendolibrosbackend.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public List<Rol> findAll() {
		return rolRepository.findAll();
	}

	@Override
	public Rol findById(Integer id) {
		Rol genero = rolRepository.findOneByIdRol(id);
		if (genero == null) {
			throw new UsernameNotFoundException(String.format("Rol no existe", id));
		} else {
			return genero;
		}
	}

	@Override
	public Rol save(Rol rol) {
		
		if(rolRepository.findOneByDescripcion(rol.getDescripcion()) != null) {
			throw new DataIntegrityViolationException("El Rol " + rol.getDescripcion() + " ya existe");
		}
		
		String validar = Utils.validarModelos(rol); 
		if(validar.isEmpty()) {
			return rolRepository.save(rol);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public Rol update(Rol rol) {
		if (rolRepository.findOneByIdRol(rol.getIdRol()) == null) {
			throw new UsernameNotFoundException(String.format("Rol no existe para modificar", rol.getIdRol()));
		}
		
		if(rolRepository.findOneByDescripcion(rol.getDescripcion()) != null) {
			throw new DataIntegrityViolationException("El Rol " + rol.getDescripcion() + " ya existe");
		}
		
		String validar = Utils.validarModelos(rol); 
		if(validar.isEmpty()) {
			return rolRepository.save(rol);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public String delete(Integer id) {
		if (rolRepository.findOneByIdRol(id) == null) {
			throw new UsernameNotFoundException(String.format("Rol no existe para eliminar", id));
		} else {
			rolRepository.deleteById(id);
		}
		return "Rol eliminado correctamente";
	}

	
}
