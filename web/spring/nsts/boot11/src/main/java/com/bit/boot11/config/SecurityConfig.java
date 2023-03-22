package com.bit.boot11.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bit.boot11.utils.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
		
	   @Autowired
	   JwtUtil jwtUtil;
	
	   @Bean
	   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	      http
	         .authorizeHttpRequests((requests) -> requests
	            .antMatchers("/", "/token").permitAll()
	            .anyRequest().authenticated()
	         )
	         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	         .and()
	         .addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
	         ;
	         
	      http.csrf().disable();

	      return http.build();
	   }
	
}
