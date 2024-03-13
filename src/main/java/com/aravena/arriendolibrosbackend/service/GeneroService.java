package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.model.Genero;

public interface GeneroService {
	public List<Genero> findAll();
	public Genero findById(Integer id);
	public Genero save(Genero genero);
	public Genero update(Genero genero);
	public String delete(Integer id);
}
