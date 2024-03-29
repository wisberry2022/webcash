package com.bit.boot10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	   @Bean
	   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	      http
	         .authorizeHttpRequests((requests) -> requests
	            .antMatchers("/", "/join").permitAll()
	            .anyRequest().authenticated()
	         )
	         .formLogin((form) -> form
	            .loginPage("/login")
//	            .successForwardUrl("/login")
	            .permitAll()
	         )
	         .logout((logout) -> logout
	        		 .logoutSuccessUrl("/")
	        		 .permitAll()
			 );
	         
	      http.csrf().disable();

	      return http.build();
	   }
}
