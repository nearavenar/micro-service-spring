package com.aravena.arriendolibrosbackend.servicesImpl;

import com.aravena.arriendolibrosbackend.model.Usuario;
import com.aravena.arriendolibrosbackend.repository.UsuarioRepository;
import com.aravena.arriendolibrosbackend.service.UsuarioService;
import com.aravena.arriendolibrosbackend.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ValidationException;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@Override
	public UserDetails loadUserByUsername(String nomusuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findOneByUsuario(nomusuario);
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("El usuario no existe", nomusuario));
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		usuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getDescripcion()));
		});
		UserDetails ud = new User(usuario.getNombre(), usuario.getPassword(), roles);
		return ud;
	}
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Integer id) {
		Usuario usuario = usuarioRepository.findOneByIdUsuario(id);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", id));
		} else {
			return usuario;
		}
	}

	@Override
	public Usuario save(Usuario usuario) {		
		if (usuarioRepository.findOneByUsuario(usuario.getUsuario()) != null) {
			throw new DataIntegrityViolationException("El Usuario " + usuario.getUsuario()+ " ya existe");
		} 
						
		String validar = Utils.validarModelos(usuario); 
		if(validar.isEmpty()) {
			String password = usuario.getPassword();
			usuario.setPassword(Utils.encriptarPassword(usuario.getPassword()));
			Usuario user = usuarioRepository.save(usuario);
			user.setPassword(password);
			return user;
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public Usuario update(Usuario usuario) {
		if (usuarioRepository.findOneByIdUsuario(usuario.getIdUsuario()) == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe para modificar", usuario.getIdUsuario()));
		}
		
		String validar = Utils.validarModelos(usuario); 
		if(validar.isEmpty()) {
			
			String password = usuario.getPassword();
			usuario.setPassword(Utils.encriptarPassword(usuario.getPassword()));
			Usuario user = usuarioRepository.save(usuario);
			user.setPassword(password);
			return user;
		}else {			
			throw new ValidationException(validar);
		}
	}
	
	@Override
	public String delete(Integer id) {
		if (usuarioRepository.findOneByIdUsuario(id) == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe para eliminar", id));
		} else {
			usuarioRepository.deleteById(id);
		}
		return "Libro eliminado correctamente";
	}
}