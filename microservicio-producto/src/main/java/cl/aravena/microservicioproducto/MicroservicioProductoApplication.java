package cl.aravena.microservicioproducto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicioProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioProductoApplication.class, args);
	}

}
