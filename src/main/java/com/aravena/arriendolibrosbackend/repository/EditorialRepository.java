package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aravena.arriendolibrosbackend.model.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>  {
	public Editorial findOneByIdEditorial(Integer idEditorial);
	public Editorial findOneByNombre(String nombre);	
}
