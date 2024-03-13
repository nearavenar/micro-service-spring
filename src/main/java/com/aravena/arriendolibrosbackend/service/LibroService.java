package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.model.Libro;

public interface LibroService {
	public List<Libro> findAll();
	public Libro findById(Integer id);
	public Libro save(Libro libro);
	public Libro update(Libro libro);
	public String delete(Integer id);
}
