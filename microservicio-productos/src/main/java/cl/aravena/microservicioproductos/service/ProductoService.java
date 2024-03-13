package cl.aravena.microservicioproductos.service;

import java.util.List;

import cl.aravena.microservicioproductos.models.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	public Producto findById(Integer id);
	public Producto save(Producto p);
	public Producto update(Producto p);
	public void deleteById(Integer id);
}
