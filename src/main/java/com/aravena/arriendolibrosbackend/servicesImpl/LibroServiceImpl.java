package com.aravena.arriendolibrosbackend.servicesImpl;

import java.util.List;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aravena.arriendolibrosbackend.model.Libro;
import com.aravena.arriendolibrosbackend.repository.LibroRepository;
import com.aravena.arriendolibrosbackend.service.LibroService;
import com.aravena.arriendolibrosbackend.util.Utils;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}

	@Override
	public Libro findById(Integer id) {
		Libro libro = libroRepository.findOneByIdLibro(id);
		if (libro == null) {
			throw new UsernameNotFoundException(String.format("Libro no existe", id));
		} else {
			return libro;
		}
	}

	@Override
	public Libro save(Libro libro) {
		if (libroRepository.findOneByTitulo(libro.getTitulo()) != null) {
			throw new DataIntegrityViolationException("El Libro " + libro.getTitulo() + " ya existe");
		}
		
		String validar = Utils.validarModelos(libro); 
		if(validar.isEmpty()) {
			return libroRepository.save(libro);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public Libro update(Libro libro) {
		if (libroRepository.findOneByIdLibro(libro.getIdLibro()) == null) {
			throw new UsernameNotFoundException(String.format("Libro no existe para modificar", libro.getIdLibro()));
		}
		
		if (libroRepository.findOneByTitulo(libro.getTitulo()) != null) {
			throw new DataIntegrityViolationException("El Libro " + libro.getTitulo() + " ya existe");
		}
		
		String validar = Utils.validarModelos(libro); 
		if(validar.isEmpty()) {
			return libroRepository.save(libro);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public String delete(Integer id) {
		if (libroRepository.findOneByIdLibro(id) == null) {
			throw new UsernameNotFoundException(String.format("Libro no existe para eliminar", id));
		} else {
			libroRepository.deleteById(id);
		}
		return "Libro eliminado correctamente";
	}
}
