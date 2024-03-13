package cl.aravena.microservicioproducto.service;

import java.util.List;

import cl.aravena.microservicioproducto.models.Proveedor;

public interface ProveedorService {
	
	public List<Proveedor> findAll();
	public Proveedor findById(Integer id);
	public Proveedor save(Proveedor e);
	public Proveedor update(Proveedor e);
	public void deleteById(Integer id);
}
