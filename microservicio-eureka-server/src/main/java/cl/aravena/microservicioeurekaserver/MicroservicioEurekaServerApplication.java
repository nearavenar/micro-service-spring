package cl.aravena.microservicioeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservicioEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioEurekaServerApplication.class, args);
	}

}