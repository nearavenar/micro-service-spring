package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aravena.arriendolibrosbackend.model.EstadoArriendo;;

@Repository
public interface EstadoArriendoRepository extends JpaRepository<EstadoArriendo, Integer>  {
	EstadoArriendo findOneByIdEstadoArriendo(Integer idEstadoArriendo);
}
