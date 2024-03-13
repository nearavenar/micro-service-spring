package cl.aravena.microservicioproducto.service;

import java.util.List;

import cl.aravena.microservicioproducto.models.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	public Producto findById(Integer id);
	public Producto save(Producto p);
	public Producto update(Producto p);
	public void deleteById(Integer id);
}
