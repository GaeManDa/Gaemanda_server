package com.gaemanda.gaemanda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GaemandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaemandaApplication.class, args);
	}

}
