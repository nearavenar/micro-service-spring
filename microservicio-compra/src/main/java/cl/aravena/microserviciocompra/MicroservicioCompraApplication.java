package cl.aravena.microserviciocompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cl.aravena.microserviciocompra.client")
public class MicroservicioCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCompraApplication.class, args);
	}

}
