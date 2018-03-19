package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.javapoint"})
public class SpringBootRestapiEx2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestapiEx2Application.class, args);
	}
}
