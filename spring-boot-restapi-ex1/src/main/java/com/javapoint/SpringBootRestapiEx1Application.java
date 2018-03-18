package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@PropertySource("classpath:application.properties")
@PropertySource("application.properties")
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages={"com.javapoint"})
public class SpringBootRestapiEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestapiEx1Application.class, args);
	}
}
