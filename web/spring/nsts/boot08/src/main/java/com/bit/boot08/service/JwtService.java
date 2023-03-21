package com.bit.boot08.service;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JwtService {
	
	String secretKey = "secret";
	
	public String verify(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secretKey);
		    JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    return jwt.getClaim("user").asString();
		} catch (JWTVerificationException exception){
		    //Invalid signature/claims
		}
		return null;
	}
	
	public String createHS256() {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secretKey);
		    String token = JWT.create()
//		        .withIssuer("auth0")
		        .withClaim("user", "user02")
		        .sign(algorithm);
		    return token;
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		
		return null;
	}
}
