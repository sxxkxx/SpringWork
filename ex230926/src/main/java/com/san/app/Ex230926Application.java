package com.san.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.san.app.**.map")
public class Ex230926Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex230926Application.class, args);
	}

}
