package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;

public interface ICRUD<E> {

	E findById(Integer id) throws Exception;
    List<E> findAll();
    E save(E e);
    E update(E e);
    boolean deleteById(Integer id) throws Exception;
}
