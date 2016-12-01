package com.upe.snu.appliction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.upe.snu.context")
public class SnuApplication {
	public static void main(String[] args) {
		SpringApplication.run(SnuApplication.class, args);
	}
}
