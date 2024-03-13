package cl.aravena.microserviciozuul.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@RefreshScope
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${config.security.oauth.jwt.key}")
	private String jwtKey;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/security/**").permitAll()

		.antMatchers(HttpMethod.GET, "/api/cuenta/buscaTodosUsuarios").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/api/cuenta/buscarUsuarioPorId/{id}").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.GET, "/api/cuenta/buscarUsuarioPorNombre").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/api/cuenta/crearUsuario").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.PUT, "/api/cuenta/actualizarUsuario").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.DELETE, "/api/cuenta/eliminaUsuarioPorId/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/api/cuenta/detalleCompraPorIdUsuario/{idUser}").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.GET, "/api/cuenta/detalleCompraPorId/{idCompra}/{idUser}").hasAnyRole("ADMIN", "USER")
		
		.antMatchers(HttpMethod.GET, "/api/compra/buscaTodasCompras").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/api/compra/buscarCompraPorId/{id}").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/api/compra/crearCompra").hasRole("USER")
		.antMatchers(HttpMethod.PUT, "/api/compra/actualizarCompra").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.DELETE, "/api/compra/eliminaCompraPorId/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/api/compra/detalleCompra").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.GET, "/api/compra/detalleCompraPorId/{idCompra}/{idUser}").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.GET, "/api/compra/detalleCompraPorIdUsuario/{idUser}").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.GET, "/api/compra/listaTodosProductos").permitAll()
		.antMatchers(HttpMethod.GET, "/api/compra/buscarProductoPorId/{id}").permitAll()

		.antMatchers(HttpMethod.GET,"/api/producto/buscaTodosProductos").permitAll()
		.antMatchers(HttpMethod.GET, "/api/producto/buscarProductoPorId/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api/producto/crearProducto").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/producto/actualizarProducto").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/producto/eliminaProductoPorId/{id}").hasRole("ADMIN")

		.antMatchers(HttpMethod.GET, "/api/categoria/buscaTodasCategorias").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/api/categoria/buscarCategoriaPorId/{id}").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/categoria/crearCategoria").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/categoria/actualizarCategoria").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/categoria/eliminaCategoriaPorId/{id}").hasRole("ADMIN")

		.antMatchers(HttpMethod.GET, "/api/proveedor/buscaTodosProveedor").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/api/proveedor/buscarProveedorPorId/{id}").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/proveedor/crearProveedor").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/proveedor/actualizarProveedor").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/proveedor/eliminaProveedorPorId/{id}").hasRole("ADMIN")

		.anyRequest().authenticated().and().cors().configurationSource(corsConfigurationSource());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(jwtKey);
		return tokenConverter;
	}
}