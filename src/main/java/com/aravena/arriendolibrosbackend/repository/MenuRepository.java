package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aravena.arriendolibrosbackend.model.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

	@Query(value = "select m.* from menu_rol mr inner join usuario_rol ur on ur.id_rol = mr.id_rol inner join menu m on m.id_menu = mr.id_menu inner join usuario u on u.id_usuario = ur.id_usuario where u.usuario = :usuario", nativeQuery = true)
	List<Object[]> listarMenuPorUsuario(@Param("usuario") String nombre);
}
