package com.jacaranda;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${env1.test.controller.root}")
public class TestController {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(TestController.class);
	
	
	@RequestMapping(path = "/prueba", method=RequestMethod.GET)
	public String pruebas() {
		logger.error("Metodo prueba llamado");
		return "Prueba correcta";
	}
	
	@GetMapping(path = "/test")
	public String pruebaTest() {
		
		return "Prueba correcta2";
	}
	
	@PostMapping(path = "/testPost{id}")
	public String pruebaPost(@PathVariable String id) {
		
		return ("hola"+id);
	}
	
	@RequestMapping(path = "/testPost2", method=RequestMethod.POST)
	public String pruebaPost2() {
		
		return "Prueba post 2";
	}
	
	@DeleteMapping(path ="testDelete")
	public String pruebaDelete(@RequestParam String delete) {
		
		return ("hola "+delete);
	}
	
	@PutMapping(path ="testPut")
	public String pruebaPut(@RequestParam String put) {
		
		return ("hola "+put);
	}



}
