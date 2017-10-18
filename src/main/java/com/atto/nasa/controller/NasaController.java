package com.atto.nasa.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class NasaController {
	
	@RequestMapping(value = "/mars/{path}", method = RequestMethod.GET, produces = "application/json")
	public String navigateRobot(@PathVariable("path") String path) {
		return "works!";
	
	}
}