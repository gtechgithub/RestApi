package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages={"com.javapoint"})
public class SprintBootRestApiFormParamEx3 {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootRestApiFormParamEx3.class, args);
	}
}
