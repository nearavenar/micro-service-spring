package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aravena.arriendolibrosbackend.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>  {
	Genero findOneByIdGenero(Integer idGenero);
	Genero findOneByNombre(String nombre);
}
