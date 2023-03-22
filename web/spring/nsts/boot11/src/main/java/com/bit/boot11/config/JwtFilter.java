package com.bit.boot11.config;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bit.boot11.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter{

	final JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorization = req.getHeader("authorization");	
		
		//token
		if(authorization == null || !authorization.startsWith("Bearer ")) {
			filterChain.doFilter(req, resp);
			return;
		}
		
		authorization = authorization.replace("Bearer ", "");
		System.out.println(authorization);
		Jws<Claims> jws = jwtUtil.getJwt(authorization);
		System.out.println(jws);
		if(jws == null || jws.getBody().getExpiration().before(new Date())) {
//		if(jws == null) {	
			filterChain.doFilter(req, resp);
			return;
		}
		
		String ename = jwtUtil.getJwtName(authorization);
		System.out.println(ename);
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(new UsernamePasswordAuthenticationToken(ename, null, List.of(new SimpleGrantedAuthority("USER"))));
		filterChain.doFilter(req, resp);
	}



}
