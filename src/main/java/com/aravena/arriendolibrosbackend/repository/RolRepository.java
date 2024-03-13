package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aravena.arriendolibrosbackend.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>  {
	public Rol findOneByIdRol(Integer idRol);
	public Rol findOneByDescripcion(String descripcion);	
}
