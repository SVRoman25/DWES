package com.jacaranda.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${env3.test.controller.root}")
public class Base {

	
	private ArrayList<Cliente> cliente;
	private ArrayList<Producto> producto;
	
	public Base() {
		
		this.cliente =new ArrayList<>() {{
			add(new Cliente("samuel","vidal","12345678f","5678904","noseque@gmail.com"));
		}};
	}
	
	public Base(Cliente cliente) {
		this.cliente =new ArrayList<Cliente>();
		
		
	}
	
	public Base(Producto producto) {
		this.producto=new ArrayList<Producto>();
		
	}
	
	public Base(Producto producto, Cliente cliente) {
		
		this.producto=new ArrayList<Producto>();
		this.cliente =new ArrayList<Cliente>();
	}
	
	
	@PostMapping(path = "/crearCliente")
	public ResponseEntity<?> añadirCliente(@RequestBody Cliente cli) {
		boolean existe=false;
		
		for(int i=0; i<cliente.size() && existe!=true; i++) {
			
			if(cliente.get(i).getDni().equalsIgnoreCase(cli.getDni())) {
				
				existe=true;	
			}
		}
		
		if(existe==true) {
	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente ya existe");
		}else {
			
			cliente.add(cli);
			return ResponseEntity.status(HttpStatus.CREATED).body(cli);

		}
	}

	@GetMapping(path="/leerCliente")
	public List<Cliente> leerCliente(){
		
		return cliente;
		
	}
	
	@PostMapping(path = "/crearProducto")
	public ResponseEntity<?> añadirProducto(@RequestBody Producto pro) {
		boolean existe=false;
		
		for(int i=0; i<cliente.size() && existe!=true; i++) {
			
			if(producto.get(i).getId()==pro.getId()) {
				
				existe=true;	
			}
		}
		
		if(existe==true) {
	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente ya existe");
		}else {
			
			producto.add(pro);
			return ResponseEntity.status(HttpStatus.CREATED).body(pro);

		}
	}

	
	public ArrayList<Cliente> getCliente() {
		return cliente;
	}

	

	public ArrayList<Producto> getProducto() {
		return producto;
	}

	
	
	
}
