package com.javapoint;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

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

	 
	 @RequestMapping(value="/showform",method=RequestMethod.GET)
	 public ModelAndView showFormMethod(){
		 Employee emp = new Employee();
		 ModelAndView model = new ModelAndView();
		 model.setViewName("showForm");
		 model.addObject("Employee", emp);
		 return model;
		 
		 
		 //return "showForm";
	 }
	 
	 @RequestMapping(value="/formParameters",method=RequestMethod.POST)
	 public ResponseEntity<?> formParametersMethod(@Form MyForm myform){
		 
		 System.out.println("firstname:" + myform.firstName);
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
}