package com.bit.boot08.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CryptServiceTest {
	String msg;
	
	@Autowired
	CryptService cryptService;
	
	
	@BeforeEach
	void setUp() throws Exception {
		msg = "abcd1234";
	}
	
	@Test
	void test() throws Exception {
		String result = cryptService.createAESEncrypt(msg);
		String result2 = cryptService.createAESDecrypt(result);
		System.out.println(result2);
	}
	
   @Test
   void test2() throws Exception {
      String result1 = cryptService.createAESEncrypt(msg);
      String result2 = cryptService.createAESDecrypt(msg);
      System.out.println(result1);
      System.out.println(result2);
   }
	
	@Test
	void test03() {
		String result = cryptService.springEncrypt(msg);
		System.out.println(result);
		result = cryptService.springEncrypt(msg);
		System.out.println(result);
		result = cryptService.springEncrypt(msg);
		System.out.println(result);
	}

	@Test
	void test04() {
		String result = cryptService.springEncrypt(msg);
		System.out.println(result);
		System.out.println(cryptService.isMatches(msg, "$2a$10$NC66jYoPp5kgxncLpcwCZeJmUsHNrM3HOI8dzc6NtrG18/sE3.xpa"));
	}
}
