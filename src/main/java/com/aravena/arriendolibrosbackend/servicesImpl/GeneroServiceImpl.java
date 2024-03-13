package com.aravena.arriendolibrosbackend.servicesImpl;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aravena.arriendolibrosbackend.model.Genero;
import com.aravena.arriendolibrosbackend.repository.GeneroRepository;
import com.aravena.arriendolibrosbackend.service.GeneroService;
import com.aravena.arriendolibrosbackend.util.Utils;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
	private GeneroRepository generoRepository;
	
	@Override
	public List<Genero> findAll() {
		return generoRepository.findAll();
	}

	@Override
	public Genero findById(Integer id) {
		Genero genero = generoRepository.findOneByIdGenero(id);
		if (genero == null) {
			throw new UsernameNotFoundException(String.format("Genero no existe", id));
		} else {
			return genero;
		}
	}

	@Override
	public Genero save(Genero genero) {
		if (generoRepository.findOneByNombre(genero.getNombre()) != null) {
			throw new DataIntegrityViolationException("El Genero " + genero.getNombre() + " ya existe");
		}
		
		String validar = Utils.validarModelos(genero); 
		if(validar.isEmpty()) {
			return generoRepository.save(genero);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public Genero update(Genero genero) {
		if (generoRepository.findOneByIdGenero(genero.getIdGenero()) == null) {
			throw new UsernameNotFoundException(String.format("Genero no existe para modificar", genero.getIdGenero()));
		} 
		
		if (generoRepository.findOneByNombre(genero.getNombre()) != null) {
			throw new DataIntegrityViolationException("El Genero " + genero.getNombre() + " ya existe");
		}
		
		String validar = Utils.validarModelos(genero); 
		if(validar.isEmpty()) {
			return generoRepository.save(genero);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public String delete(Integer id) {
		if (generoRepository.findOneByIdGenero(id) == null) {
			throw new UsernameNotFoundException(String.format("Genero no existe para eliminar", id));
		} else {
			generoRepository.deleteById(id);
		}
		return "Genero eliminado correctamente";
	}
}
