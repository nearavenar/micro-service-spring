package cl.aravena.microserviciosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MicroservicioSecurityApplication  implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		
		for (int i = 0; i < 2; i++) {
			String passwordBCrypt = passwordEncode.encode(password);
			System.out.println(passwordBCrypt);
		}
		
		String passwordBCrypt = passwordEncode.encode("elsecreto");
		System.out.println(passwordBCrypt);
	}

}
