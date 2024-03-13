package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.model.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Integer id);
	public Usuario save(Usuario genero);
	public Usuario update(Usuario genero);
	public String delete(Integer id);
}
