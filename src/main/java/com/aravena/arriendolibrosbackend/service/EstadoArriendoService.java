package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.model.EstadoArriendo;

public interface EstadoArriendoService {

	public List<EstadoArriendo> findAll();
	public EstadoArriendo findById(Integer id);
	public EstadoArriendo save(EstadoArriendo estadoArriendo);
	public EstadoArriendo update(EstadoArriendo estadoArriendo);
	public String delete(Integer id);
}
