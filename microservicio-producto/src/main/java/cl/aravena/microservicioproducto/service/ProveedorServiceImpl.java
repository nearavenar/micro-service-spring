package cl.aravena.microservicioproducto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aravena.microservicioproducto.models.Proveedor;
import cl.aravena.microservicioproducto.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public List<Proveedor> findAll() {
		return proveedorRepository.findAll();
	}

	@Override
	public Proveedor findById(Integer id) {
		return proveedorRepository.findById(id).orElse(null);
	}

	@Override
	public Proveedor save(Proveedor e) {
		return proveedorRepository.save(e);
	}

	@Override
	public Proveedor update(Proveedor e) {
		Proveedor empresaUpd = findById(e.getRut());
		empresaUpd.setNombre(e.getNombre());
		empresaUpd.setTelefono(e.getTelefono());
		empresaUpd.setDireccion(e.getDireccion());
		return proveedorRepository.save(e);
	}

	@Override
	public void deleteById(Integer id) {
		proveedorRepository.deleteById(id);
	}
}
