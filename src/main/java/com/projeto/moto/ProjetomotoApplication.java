package com.projeto.moto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication /*Tira a configuração padrão do security*/
public class ProjetomotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetomotoApplication.class, args);
	}

}
