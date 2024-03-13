package com.aravena.arriendolibrosbackend.service;

import com.aravena.arriendolibrosbackend.model.Usuario;

public interface LoginService {

	Usuario verificarNombreUsuario(String usuario) throws Exception;
    int cambiarClave(String clave, String nombre) throws Exception;
}
