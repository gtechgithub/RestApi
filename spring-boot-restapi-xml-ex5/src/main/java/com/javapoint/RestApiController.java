package com.javapoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.jboss.resteasy.annotations.Form;


@RestController
@RequestMapping("/api")
public class RestApiController {

	 public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	 @RequestMapping(value="/getXml", method=RequestMethod.GET, produces="Application/xml")
	 public ResponseEntity<Employee> getXmlResponse(){
		 
		 Employee emp = new Employee();
		 emp.setId(1);
		 emp.setFirstName("firstname1");
		 emp.setLastName("lastname1");
		 emp.setSalary(10000);
		 
		 return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		 
	 }
}