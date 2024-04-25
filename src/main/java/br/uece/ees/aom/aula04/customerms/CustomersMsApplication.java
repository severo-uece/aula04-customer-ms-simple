package br.uece.ees.aom.aula04.customerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomersMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersMsApplication.class, args);
	}

}
