package cl.aravena.microserviciocuenta.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aravena.microserviciocuenta.client.CompraClient;
import cl.aravena.microserviciocuenta.dto.CompraDto;
import cl.aravena.microserviciocuenta.dto.DetalleCompraDto;
import cl.aravena.microserviciocuenta.models.Usuario;
import cl.aravena.microserviciocuenta.repository.UsuarioRepository;
import cl.aravena.microserviciocuenta.utils.Utils;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CompraClient compraClient;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@Override
	public Usuario findByUserName(String usuario) {
		return usuarioRepository.findByUsername(usuario);
	}

	@Override
	public Usuario save(Usuario u) {
		String password = u.getPassword();
		u.setPassword(Utils.encriptarPassword(u.getPassword()));
		Usuario user = usuarioRepository.save(u);
		user.setPassword(password);
		return user;
	}

	@Override
	public Usuario update(Usuario u) {
		Usuario usuarioUpd = findById(u.getIdUsuario());
		if(usuarioUpd!=null) {			
			u.setUsername(usuarioUpd.getUsername());
			
			String password = u.getPassword();
			u.setPassword(Utils.encriptarPassword(u.getPassword()));
			Usuario user = usuarioRepository.save(u);
			user.setPassword(password);
			return user;
		}else {
			return u;
		}
	}

	@Override
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public List<CompraDto> findDetalleCompraByIdUser(Integer idUser) {
		return compraClient.findDetalleCompraByIdUser(idUser);
	}
	
	@Override
	public CompraDto findDetalleCompraByIdCompraAndIdUser(Integer id, Integer idUser) {
		return compraClient.findDetalleCompraByIdCompraAndIdUser(id, idUser);
	}
	
	@Override
	public List<CompraDto> findDetalleCompraByIdUserAlternativo(Integer idUser) {
		List<CompraDto> listaCompras = new ArrayList<CompraDto>();		
		List<DetalleCompraDto> detalleCompraDto = new ArrayList<DetalleCompraDto>();
		
		DetalleCompraDto detalle = new DetalleCompraDto(0, 0, 0, 0);
		detalleCompraDto.add(detalle);
		
		CompraDto compra = new CompraDto(0, 0, LocalDate.now(), 0, detalleCompraDto );
		listaCompras.add(compra);
		return listaCompras;
	}
}
