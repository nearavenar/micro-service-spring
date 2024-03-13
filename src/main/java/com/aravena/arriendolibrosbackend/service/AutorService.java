package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.model.Autor;

public interface AutorService {
	public List<Autor> findAll();
	public Autor findById(Integer id);
	public Autor save(Autor autor);
	public Autor update(Autor autor);
	public boolean delete(Integer id);
}
