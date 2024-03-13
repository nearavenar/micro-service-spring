package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.model.Idioma;

public interface IdiomaService {

	public List<Idioma> findAll();
	public Idioma findById(Integer id);
	public Idioma save(Idioma idioma);
	public Idioma update(Idioma idioma);
	public String delete(Integer id);
}
