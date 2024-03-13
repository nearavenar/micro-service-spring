package com.aravena.arriendolibrosbackend.servicesImpl;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aravena.arriendolibrosbackend.model.Autor;
import com.aravena.arriendolibrosbackend.repository.AutorRepository;
import com.aravena.arriendolibrosbackend.service.AutorService;
import com.aravena.arriendolibrosbackend.util.Utils;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}

	@Override
	public Autor findById(Integer id) {
		Autor autor = autorRepository.findOneByIdAutor(id);
		if (autor == null) {
			throw new UsernameNotFoundException(String.format("Autor no existe", id));
		} else {
			return autor;
		}
	}

	@Override
	public Autor save(Autor autor) {
		
		if (autorRepository.findOneByNombre(autor.getNombre()) != null) {
			throw new DataIntegrityViolationException("El Autor " + autor.getNombre() + " ya existe");
		}
		
		String validar = Utils.validarModelos(autor); 
		if(validar.isEmpty()) {
			return autorRepository.save(autor);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public Autor update(Autor autor) {
		if (autorRepository.findOneByIdAutor(autor.getIdAutor()) == null) {
			throw new UsernameNotFoundException(String.format("Autor no existe para modificar", autor.getIdAutor()));
		}
		
		if (autorRepository.findOneByNombre(autor.getNombre()) != null) {
			throw new DataIntegrityViolationException("El Autor " + autor.getNombre() + " ya existe");
		}
		
		String validar = Utils.validarModelos(autor); 
		if(validar.isEmpty()) {
			return autorRepository.save(autor);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public boolean delete(Integer id) {
		if (autorRepository.findOneByIdAutor(id) == null) {
			throw new UsernameNotFoundException(String.format("Autor no existe para eliminar", id));
		} else {
			autorRepository.deleteById(id);
		}
		return true;
	}
}
