package cl.aravena.microservicioproducto.service;

import java.util.List;

import cl.aravena.microservicioproducto.models.Categoria;

public interface CategoriaService {

	public List<Categoria> findAll();
	public Categoria findById(Integer id);
	public Categoria save(Categoria c);
	public Categoria update(Categoria c);
	public void deleteById(Integer id);
}
