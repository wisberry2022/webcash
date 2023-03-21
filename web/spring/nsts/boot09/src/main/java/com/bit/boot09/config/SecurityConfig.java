package com.bit.boot09.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
         .authorizeHttpRequests((requests) -> requests
            .antMatchers("/", "/ex01").permitAll()
            .anyRequest().authenticated()
         )
         .formLogin((form) -> form
            .loginPage("/login")
            .permitAll()
         )
         .logout((logout) -> logout
        		 .logoutSuccessUrl("/")
        		 .permitAll()
		 );
         
      http.csrf().disable();

      return http.build();
   }
   
//   @Bean 
//   UserDetailsService userDetailService() {
//	   UserDetails user =
//			   User.withDefaultPasswordEncoder()
//			   .username("user01")
//			   .password("1234")
//			   .roles("USER")
//			   .build();
//	   
//	   return new InMemoryUserDetailsManager(
//			   user, 
//			   User.withDefaultPasswordEncoder().username("user02").password("1234").roles("USER").build(),
//			   User.withDefaultPasswordEncoder().username("user03").password("1234").roles("USER").build(),
//			   User.withDefaultPasswordEncoder().username("user04").password("1234").roles("USER").build()
//			   
//			   );
//   }
   
   
}