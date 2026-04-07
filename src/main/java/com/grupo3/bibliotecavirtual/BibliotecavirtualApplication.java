package com.grupo3.bibliotecavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BibliotecavirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecavirtualApplication.class, args);
	}

}
