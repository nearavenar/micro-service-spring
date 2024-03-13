package cl.aravena.microservicioproducto.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cl.aravena.microservicioproducto.models.Producto;
import cl.aravena.microservicioproducto.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Integer id) {
		return productoRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Producto update(Producto p) {
		Producto ProductoUpd = findById(p.getIdProducto());
		ProductoUpd.setNombre(p.getNombre());
		ProductoUpd.setValor(p.getValor());		
		return productoRepository.save(p);
	}
	
	@Override
	@Transactional
	public Producto save(Producto p) {
		return productoRepository.save(p);
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
		productoRepository.deleteById(id);
	}
}
