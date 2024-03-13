package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.model.Rol;

public interface RolService {

	public List<Rol> findAll();
	public Rol findById(Integer id);
	public Rol save(Rol rol);
	public Rol update(Rol rol);
	public String delete(Integer id);
}
