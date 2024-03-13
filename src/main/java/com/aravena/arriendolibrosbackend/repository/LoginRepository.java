package com.aravena.arriendolibrosbackend.repository;

import com.aravena.arriendolibrosbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LoginRepository extends JpaRepository<Usuario, Integer> {

    @Query("FROM Usuario u where u.email = :email")
    Usuario verificarNombreUsuario(@Param("email") String nombre) throws Exception;

    @Transactional
    @Modifying
    @Query("UPDATE Usuario u SET u.password = :clave WHERE u.email = :email")
    void cambiarClave(@Param("clave") String clave, @Param("email") String nombre) throws Exception;

}