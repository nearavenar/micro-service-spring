package com.aravena.arriendolibrosbackend.servicesImpl;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aravena.arriendolibrosbackend.model.Idioma;
import com.aravena.arriendolibrosbackend.repository.IdiomaRepository;
import com.aravena.arriendolibrosbackend.service.IdiomaService;
import com.aravena.arriendolibrosbackend.util.Utils;

@Service
public class IdiomaServiceImpl implements IdiomaService{

	@Autowired
	private IdiomaRepository idiomaRepository;
	
	@Override
	public List<Idioma> findAll() {
		return idiomaRepository.findAll();
	}

	@Override
	public Idioma findById(Integer id) {
		Idioma idioma = idiomaRepository.findOneByIdIdioma(id);
		if (idioma == null) {
			throw new UsernameNotFoundException(String.format("Idioma no existe", id));
		} else {
			return idioma;
		}
	}

	@Override
	public Idioma save(Idioma idioma) {
		
		if (idiomaRepository.findOneByDescripcion(idioma.getDescripcion()) != null) {
			throw new DataIntegrityViolationException("El Idioma " + idioma.getDescripcion() + " ya existe");
		}
		
		String validar = Utils.validarModelos(idioma); 
		if(validar.isEmpty()) {
			return idiomaRepository.save(idioma);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public Idioma update(Idioma idioma) {
		if (idiomaRepository.findOneByIdIdioma(idioma.getIdIdioma()) == null) {
			throw new UsernameNotFoundException(String.format("Idioma no existe para modificar", idioma.getIdIdioma()));
		} 
		
		if (idiomaRepository.findOneByDescripcion(idioma.getDescripcion()) != null) {
			throw new DataIntegrityViolationException("El Idioma " + idioma.getDescripcion() + " ya existe");
		}
		
		String validar = Utils.validarModelos(idioma); 
		if(validar.isEmpty()) {
			return idiomaRepository.save(idioma);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public String delete(Integer id) {
		if (idiomaRepository.findOneByIdIdioma(id) == null) {
			throw new UsernameNotFoundException(String.format("Idioma no existe para eliminar", id));
		} else {
			idiomaRepository.deleteById(id);
		}
		return "Idioma eliminado correctamente";
	}
}
