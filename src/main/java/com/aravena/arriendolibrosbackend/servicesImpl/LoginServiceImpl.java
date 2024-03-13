package com.aravena.arriendolibrosbackend.servicesImpl;

import com.aravena.arriendolibrosbackend.model.Usuario;
import com.aravena.arriendolibrosbackend.repository.LoginRepository;
import com.aravena.arriendolibrosbackend.service.LoginService;
import com.aravena.arriendolibrosbackend.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public int cambiarClave(String clave, String nombre) {
        int resultado = 0;
        try {
        	loginRepository.cambiarClave(Utils.encriptarPassword(clave), nombre);
        	resultado = 1;
        } catch (Exception e) {
        	resultado = 0;
        }
        return resultado;
    }

    @Override
    public Usuario verificarNombreUsuario(String nombre) throws Exception {
        Usuario usuario = null;
        try {
        	usuario = loginRepository.verificarNombreUsuario(nombre);
        	usuario = usuario != null ? usuario : new Usuario();
        } catch (Exception e) {
        	usuario = new Usuario();
        }
        return usuario;
    }
}