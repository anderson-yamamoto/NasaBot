package com.atto.nasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class NasaController {
	
	@Autowired
	private RobotService robotService;
	
	@RequestMapping(value = "/mars/{path}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> navigateRobot(@PathVariable("path") String path) {
		try{
			return new ResponseEntity<String>(robotService.moveRobot(path), HttpStatus.OK);
		}catch(Exception e){
			//No logging as no logger libs allowed on Maven
			return new ResponseEntity<String>("400 Bad Request", HttpStatus.BAD_REQUEST);
		}
	}
}
