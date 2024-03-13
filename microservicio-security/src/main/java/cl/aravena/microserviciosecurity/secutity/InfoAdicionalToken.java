package cl.aravena.microserviciosecurity.secutity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import cl.aravena.microserviciosecurity.services.UsuarioService;
import cl.aravena.microserviciosecurity.model.Usuario;

//Clase de token potenciador, para agregar mas atributos al token
@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Map<String, Object> info = new HashMap<String, Object>();
		Usuario usuario = usuarioService.findByUserName(authentication.getName());
		
		if(usuario!=null) {
			info.put("nombre", usuario.getNombre());
			info.put("apellido", usuario.getApellido());
			info.put("email", usuario.getEmail());
		}
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
}
