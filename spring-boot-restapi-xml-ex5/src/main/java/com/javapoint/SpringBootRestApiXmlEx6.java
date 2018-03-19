package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.javapoint" })
public class SpringBootRestApiXmlEx6 {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiXmlEx6.class, args);
	}
}


/*********************** output ***************************

in postman URI --> localhost:8080/api/getXml (GET)

output
-------

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Employee>
    <firstName>firstname1</firstName>
    <id>1</id>
    <lastName>lastname1</lastName>
    <salary>10000</salary>
</Employee>



****************************************************************/