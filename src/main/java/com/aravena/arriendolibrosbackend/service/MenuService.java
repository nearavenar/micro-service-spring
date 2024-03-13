package com.aravena.arriendolibrosbackend.service;

import java.util.List;
import com.aravena.arriendolibrosbackend.model.Menu;

public interface MenuService extends ICRUD<Menu> {
	List<Menu> listarMenuPorUsuario(String nombre);
}
