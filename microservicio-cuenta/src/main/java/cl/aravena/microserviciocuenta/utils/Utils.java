package cl.aravena.microserviciocuenta.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {

	public static String encriptarPassword(String clave) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(clave);
	}
}
