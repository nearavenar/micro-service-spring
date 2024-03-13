package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aravena.arriendolibrosbackend.model.Idioma;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Integer>{
	Idioma findOneByIdIdioma(Integer IdIdioma);
	Idioma findOneByDescripcion(String descripcion);	
}
