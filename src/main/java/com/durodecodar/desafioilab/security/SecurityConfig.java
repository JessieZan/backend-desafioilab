package com.durodecodar.desafioilab.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity httpSec) throws Exception {
		System.out.println("--> SETUP da configuração de segurança com.durodecodar.desafioilab.security\n\n");

		httpSec.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/entregadores")
		.permitAll()
		.antMatchers(HttpMethod.GET, "/pedidos")
		.permitAll()

		.antMatchers(HttpMethod.GET, "/clientes")
		.permitAll()
		.antMatchers(HttpMethod.GET, "/clientes/*")
		.permitAll()
		
		.antMatchers(HttpMethod.GET, "/pedidos/em-aberto")
		.permitAll()

		.anyRequest().authenticated().and().cors();

		httpSec.addFilterBefore(new Filters(), UsernamePasswordAuthenticationFilter.class);

	}
}
