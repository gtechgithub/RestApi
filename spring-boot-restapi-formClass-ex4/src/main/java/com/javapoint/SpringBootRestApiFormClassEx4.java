package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages={"com.javapoint"})
public class SpringBootRestApiFormClassEx4 {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiFormClassEx4.class, args);
	}
}
