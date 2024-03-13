package com.aravena.arriendolibrosbackend.servicesImpl;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aravena.arriendolibrosbackend.model.Editorial;
import com.aravena.arriendolibrosbackend.repository.EditorialRepository;
import com.aravena.arriendolibrosbackend.service.EditorialService;
import com.aravena.arriendolibrosbackend.util.Utils;

@Service
public class EditorialServiceImpl implements EditorialService{

	@Autowired
	private EditorialRepository editorialRepository;
	
	@Override
	public List<Editorial> findAll() {
		return editorialRepository.findAll();
	}

	@Override
	public Editorial findById(Integer id) {
		Editorial editorial = editorialRepository.findOneByIdEditorial(id);
		if (editorial == null) {
			throw new UsernameNotFoundException(String.format("Editorial no existe", id));
		} else {
			return editorial;
		}
	}

	@Override
	public Editorial save(Editorial editorial) {
		
		if (editorialRepository.findOneByNombre(editorial.getNombre()) != null) {
			throw new DataIntegrityViolationException("El Editorial " + editorial.getNombre() + " ya existe");
		}
		
		String validar = Utils.validarModelos(editorial); 
		if(validar.isEmpty()) {
			return editorialRepository.save(editorial);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public Editorial update(Editorial editorial) {
		if(editorialRepository.findOneByIdEditorial(editorial.getIdEditorial()) == null) {
			throw new UsernameNotFoundException(String.format("Editorial no existe para modificar", editorial.getIdEditorial()));
		} 
		
		if(editorialRepository.findOneByNombre(editorial.getNombre()) != null) {
			throw new DataIntegrityViolationException("El Editorial " + editorial.getNombre() + " ya existe");
		}
		
		String validar = Utils.validarModelos(editorial); 
		if(validar.isEmpty()) {
			return editorialRepository.save(editorial);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public String delete(Integer id) {
		if (editorialRepository.findOneByIdEditorial(id) == null) {
			throw new UsernameNotFoundException(String.format("Editorial no existe para eliminar", id));
		} else {
			editorialRepository.deleteById(id);
		}
		return "Editorial eliminado correctamente";
	}
}
