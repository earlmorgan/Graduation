package com.bcdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication//
@RestController
public class SpringBootMain {
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello spring boot !!!";
	}
	
	public static void main(String[] args){
		SpringApplication.run(SpringBootMain.class, args);
	}
}
