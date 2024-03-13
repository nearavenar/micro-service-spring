package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.model.Editorial;

public interface EditorialService {
	public List<Editorial> findAll();
	public Editorial findById(Integer id);
	public Editorial save(Editorial editorial);
	public Editorial update(Editorial editorial);
	public String delete(Integer id);
}
