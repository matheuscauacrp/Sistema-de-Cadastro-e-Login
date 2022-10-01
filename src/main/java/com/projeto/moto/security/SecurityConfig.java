package com.projeto.moto.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()//Disabilitando todos acessos externos da API, somente com login tem acesso
						.authorizeHttpRequests() //Autoriza requisições abaixo
						.antMatchers(HttpMethod.GET, "/usuarios").permitAll()//Aqui permite que façam requisições GET na rota /usuarios
						.anyRequest().authenticated().and().cors();
		
		httpSecurity.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class); //Adciona filtro e Objeto para autenticação
	}
	
}
