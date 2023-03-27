package com.spring.security03.global.config;

import com.spring.security03.core.auth.getLoginStatus;
import com.spring.security03.global.auth.getLoginStatusImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("security filter");

//        http.addFilterBefore(((request, response, chain) -> {
//            System.out.println("request " + request.getParameterMap());
//            chain.doFilter(request, response);
//        }), Filter.class);

        getLoginStatus getLogin = new getLoginStatusImpl();
        if(getLogin.getStatus()) {
            http.authorizeRequests((requests) -> requests
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
            );
            return http.build();
        }
        http.authorizeRequests((requests) -> requests
                .antMatchers("/", "/webjars/**").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }
}
