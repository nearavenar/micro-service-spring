package com.aravena.arriendolibrosbackend.servicesImpl;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aravena.arriendolibrosbackend.model.EstadoArriendo;
import com.aravena.arriendolibrosbackend.repository.EstadoArriendoRepository;
import com.aravena.arriendolibrosbackend.service.EstadoArriendoService;
import com.aravena.arriendolibrosbackend.util.Utils;

@Service
public class EstadoArriendoServiceImpl implements EstadoArriendoService{

	@Autowired
	private EstadoArriendoRepository estadoArriendoRepository;
	
	@Override
	public List<EstadoArriendo> findAll() {
		return estadoArriendoRepository.findAll();
	}

	@Override
	public EstadoArriendo findById(Integer id) {
		EstadoArriendo estadoArriendo = estadoArriendoRepository.findOneByIdEstadoArriendo(id);
		if (estadoArriendo == null) {
			throw new UsernameNotFoundException(String.format("Estado de Arriendo no existe", id));
		} else {
			return estadoArriendo;
		}
	}

	@Override
	public EstadoArriendo save(EstadoArriendo estadoArriendo) {
		String validar = Utils.validarModelos(estadoArriendo); 
		if(validar.isEmpty()) {
			return estadoArriendoRepository.save(estadoArriendo);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public EstadoArriendo update(EstadoArriendo estadoArriendo) {
		if (estadoArriendoRepository.findOneByIdEstadoArriendo(estadoArriendo.getIdEstadoArriendo()) == null) {
			throw new UsernameNotFoundException(String.format("Estado de Arriendo no existe para modificar", estadoArriendo.getIdEstadoArriendo()));
		} 
		
		String validar = Utils.validarModelos(estadoArriendo); 
		if(validar.isEmpty()) {
			return estadoArriendoRepository.save(estadoArriendo);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public String delete(Integer id) {
		if (estadoArriendoRepository.findOneByIdEstadoArriendo(id) == null) {
			throw new UsernameNotFoundException(String.format("Estado de Arriendo no existe para eliminar", id));
		} else {
			estadoArriendoRepository.deleteById(id);
		}
		return "Estado de Arriendo eliminado correctamente";
	}
}
