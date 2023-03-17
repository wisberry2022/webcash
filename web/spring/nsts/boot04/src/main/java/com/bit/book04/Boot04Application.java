package com.bit.book04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bit.book04", "com.bit.boot04.service", "com.bit.boot04.controller", "com.bit.boot04.model"})
public class Boot04Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot04Application.class, args);
	}

}
