package cl.aravena.microserviciosecurity.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import cl.aravena.microserviciosecurity.model.Usuario;
import cl.aravena.microserviciosecurity.services.UsuarioService;
import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		
		//Si no es un usuario de base de datos termina el flujo
		if(authentication.getDetails() instanceof WebAuthenticationDetails) {
			return;
		}
		
		UserDetails user = (UserDetails) authentication.getPrincipal();
		System.out.println("Success Login:" + user.getUsername());
	}
	
	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		System.out.println("Error en el Login:" + exception.getMessage());
		try {
			Usuario usuario = usuarioService.findByUserName(authentication.getName());
			System.out.println("usuario : " + usuario.getUsername());
			
		} catch (FeignException e) {
			System.out.println(String.format("El usuario %s no existe en el sistema", authentication.getName()));
		}		
	}
}