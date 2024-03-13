package cl.aravena.microserviciocuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cl.aravena.microserviciocuenta.client")
@EnableCircuitBreaker
public class MicroservicioCuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCuentaApplication.class, args);
	}

}
