package cl.aravena.microserviciosecurity.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.aravena.microserviciosecurity.client.UsuarioClient;
import cl.aravena.microserviciosecurity.model.Usuario;
import feign.FeignException;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

	private Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioClient usuarioClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {

			Usuario usuario = usuarioClient.findByUserName(username);

			if (usuario == null) {
				LOG.error("Error en el login, no existe usuario " + username + " en el sistema");
				throw new UsernameNotFoundException(
						"Error en el login, no existe usuario " + username + " en el sistema");
			}

			List<GrantedAuthority> authorities = usuario.getRoles().stream()
					.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
					.peek(authority -> LOG.info("Rol: " + authority.getAuthority()))
					.collect(Collectors.toList());

			LOG.info("Usuario autentificado: " + username);
			
			return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
					authorities);

		} catch (FeignException e) {
			LOG.error("Error en el login, no existe usuario " + username + " en el sistema");
			throw new UsernameNotFoundException("Error en el login, no existe usuario " + username + " en el sistema");
		}
	}
	
	@Override
	public Usuario findByUserName(String username) {
		Usuario usuario = usuarioClient.findByUserName(username);
		return usuario;
	}
	
	@Override
	public Usuario update(Usuario usuario) {
		return usuarioClient.update(usuario);
	}
}
