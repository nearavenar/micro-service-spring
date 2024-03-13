package cl.aravena.microservicioproducto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aravena.microservicioproducto.models.Categoria;
import cl.aravena.microservicioproducto.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria findById(Integer id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	@Override
	public Categoria save(Categoria c) {
		return categoriaRepository.save(c);
	}

	@Override
	public Categoria update(Categoria c) {
		Categoria CategoriaUpd = findById(c.getIdCategoria());
		CategoriaUpd.setDescripcion(c.getDescripcion());
		return categoriaRepository.save(CategoriaUpd);
	}

	@Override
	public void deleteById(Integer id) {
		categoriaRepository.deleteById(id);
	}

}
