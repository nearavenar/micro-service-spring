package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aravena.arriendolibrosbackend.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

	Autor findOneByIdAutor(Integer idAutor);
	Autor findOneByNombre(String nombre);	
}
