package cl.aravena.microserviciocuenta.service;

import java.util.List;

import cl.aravena.microserviciocuenta.dto.CompraDto;
import cl.aravena.microserviciocuenta.models.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Integer id);
	public Usuario save(Usuario u);
	public Usuario update(Usuario u);
	public void deleteById(Integer id);
	public List<CompraDto> findDetalleCompraByIdUser(Integer idUser);
	public CompraDto findDetalleCompraByIdCompraAndIdUser(Integer id, Integer idUser);
	public Usuario findByUserName(String usuario);
	
	public List<CompraDto> findDetalleCompraByIdUserAlternativo(Integer idUser);
}
