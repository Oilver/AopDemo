package com.example.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {
    private static final Logger logger = LoggerFactory.getLogger(AopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

}
