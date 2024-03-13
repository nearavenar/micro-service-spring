package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aravena.arriendolibrosbackend.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>  {
	
	public Libro findOneByIdLibro(Integer idLibro);
	public Libro findOneByTitulo(String titulo);
	
	@Query("SELECT l.stockDisponible FROM Libro l WHERE l.idLibro = :idLibro")
	public int verStockDisponible(@Param("idLibro") Integer idLibro); 
}
