package com.javapoint;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.ws.spi.http.HttpHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class RestApiController {

	 public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	 @Autowired
	 EmployeeService service;

	 //----------------retrieve all employee----------------------
	 
	 @RequestMapping(value = "/Employee",method=RequestMethod.GET)
	 public ResponseEntity <List<Employee>> listAllEmployees(){
		 List<Employee> emp = service.listAllEmployee();
		 if (emp.isEmpty()) {
			 return new ResponseEntity(HttpStatus.NO_CONTENT);
		 }
		 
		 return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	 }
	 
	 //----------------retrieve single employee--------------------
	 
	 @RequestMapping(value = "/Employee/{id}",method=RequestMethod.GET)
	 public ResponseEntity <?> getEmployee(@PathVariable(value="id",required=true) int id ){
		 Employee emp = null;
		 emp=service.findById(id);
		 
		 if(emp == null) {
			 String errorMessage= "employee id:" + id + " not found";
			 return new ResponseEntity<CustomErrorType>(new CustomErrorType(errorMessage),HttpStatus.NOT_FOUND);
		 }
		 else {
			   return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		 }
	 }
	 

	 //----------------delete employee--------------------
	 
	 @RequestMapping(value = "/Employee/{id}",method=RequestMethod.DELETE)
	 public ResponseEntity <?> deleteEmployee(@PathVariable(value="id",required=true) int id ){
		 Employee emp = null;
		 emp=service.findById(id);
		 
		 if(emp == null) {
			 String errorMessage= "employee id:" + id + " not found for delete operation";
			 return new ResponseEntity<CustomErrorType>(new CustomErrorType(errorMessage),HttpStatus.NOT_FOUND);
		 }
		 else {
			   service.deleteEmployee(id);
			   return new ResponseEntity<Employee>(HttpStatus.OK);
		 }
	 }

	 //----------------update employee--------------------
	 
	 @RequestMapping(value = "/Employee/{id}",method=RequestMethod.PUT)
	 public ResponseEntity <?> updateEmployee(@PathVariable(value="id",required=true) int id ,
			                                  @RequestParam(value="salary",required=true) int salary){
		 Employee emp = null;
		 emp=service.findById(id);
		 
		 if(emp == null) {
			 String errorMessage= "employee id:" + id + " not found for update operation";
			 return new ResponseEntity<CustomErrorType>(new CustomErrorType(errorMessage),HttpStatus.NOT_FOUND);
		 }
		 else {
			   service.updateEmployee(id, salary);
			   return new ResponseEntity<Employee>(HttpStatus.OK);
		 }
	 }

	 //----------------insert and add employee--------------------
	 
	 @RequestMapping(value = "/Employee",method=RequestMethod.POST)
	 public ResponseEntity <?> addEmployee(@RequestBody Employee employee,UriComponentsBuilder uriBuilder){
		 
		 if(employee == null) {
			 String errorMessage= "unable to insert employee as employee is null or emptry";
			 return new ResponseEntity<CustomErrorType>(new CustomErrorType(errorMessage),HttpStatus.NOT_FOUND);
		 }
		 
		 int id = employee.getId();
		 
		 Employee emp = service.findById(id);
		 
		 //check already employee id present
		 if(emp!=  null && emp.getId() == id ) {
			 String errorMessage= "employee already avaialble hence not inserted once agaion";
			 return new ResponseEntity<CustomErrorType>(new CustomErrorType(errorMessage),HttpStatus.CONFLICT);
		 }
		 else {
			   Employee empPersistence = service.addEmployee(employee);
			   
			   HttpHeaders httpHeader =  new HttpHeaders();
			   URI urilocation = uriBuilder.path("/api/Employee/{id}").buildAndExpand(empPersistence.getId()).toUri();
			   httpHeader.setLocation(urilocation);
			   return new ResponseEntity<String>(httpHeader,HttpStatus.OK);
		 }
	 }
	 
	//---------------- get all operations--------------------
	 
		 @RequestMapping(value = "/Employee",method=RequestMethod.OPTIONS)
		 public ResponseEntity <?> getAllOperations(){

			   HttpHeaders httpHeader =  new HttpHeaders();
			   
			   Set<HttpMethod> allowedMethods= new TreeSet <HttpMethod>();
			   allowedMethods.add(HttpMethod.GET);
			   allowedMethods.add(HttpMethod.PUT);
			   allowedMethods.add(HttpMethod.DELETE);
			   allowedMethods.add(HttpMethod.POST);

			   httpHeader.setAllow(allowedMethods);
			   httpHeader.setContentType(MediaType.APPLICATION_JSON);
			   return new ResponseEntity<String>(httpHeader,HttpStatus.OK);
			   
			   
			   /********************HEADERS***********
			   allow →GET,POST,PUT,DELETE
			   content-length →0
			   content-type →application/json
			   date →Mon, 19 Mar 2018 10:16:54 GMT
				***************************/
		 }

		 
		 @RequestMapping(value = "/Employee/{id}",method=RequestMethod.HEAD)
		 public ResponseEntity <?> getHeadOperations(@PathVariable("id") int id){
			 
			 Employee emp = service.findById(id);
			  if (emp == null) {
				  return new ResponseEntity<String>("resource is not avaialble", HttpStatus.NOT_FOUND);
			  }
			 
			 if (service.findById(id).getId() == id) {			 
				 return new ResponseEntity<String>("resource is avaialble", HttpStatus.OK);
			 }
			 else {
				 return new ResponseEntity<String>("resource is not avaialble", HttpStatus.NOT_FOUND);
			 }
			 
			 /**********************
			 content-length →21
			 content-type →text/plain;charset=UTF-8
			 date →Mon, 19 Mar 2018 10:35:55 GMT
			 
			 ****************/
		 }

}