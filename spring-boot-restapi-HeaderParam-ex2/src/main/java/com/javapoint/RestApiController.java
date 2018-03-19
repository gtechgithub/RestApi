package com.javapoint;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.HttpHeaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

	 public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	 @RequestMapping(value="/Headers",method=RequestMethod.GET)
	 public ResponseEntity<?> getHeaders(@HeaderParam( "User-Agent") HeaderAgent headerAgent,
			                            @HeaderParam(HttpHeaders.ACCEPT ) String accept,
			                            @HeaderParam("Accept-Encoding") String encoding,
			                            @HeaderParam("Accept-Language") String language){
		 
		 logger.debug("user-agent"+ headerAgent);
		 System.out.println("user-agent"+ headerAgent);
		 System.out.println("accept"+ accept);
		 
		 Map<String, Object> hm = new HashMap<String,Object>();
		 hm.put("User-Agent", headerAgent);
		 hm.put("Accept", accept);
		 hm.put("Accept-Encoding", encoding);
		 hm.put("Accept-Language", language);
		 return new ResponseEntity<Map>(hm,HttpStatus.OK);
	 }

}