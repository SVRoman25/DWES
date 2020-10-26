package com.jacaranda.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.repo.CustomerRepository;
import com.jacaranda.servicios.ExisteProducto;
import com.jacaranda.servicios.ExisteUsuario;

@RestController
@RequestMapping(path = "${env3.test.controller.root}")
public class Base {

	@Autowired
	private ExisteUsuario comprobar;
	@Autowired
	private ExisteProducto comprobarProducto;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CrudRepository<Alquiler, Integer> alquilerRepositori ;
	
	private ArrayList<Cliente> cliente;
	private ArrayList<Producto> producto;
	
	public Base() {
		
		
		cliente =new ArrayList<>() {{
			add(new Cliente(1, "samuel","vidal","12345678f","23678904","noseque@gmail.com"));
			add(new Cliente(2,"Laura","bosco","87654321f","54345345","nos@gmail.com"));
			add(new Cliente(3,"juan","anton","9999999f","6796904","que@gmail.com"));
			add(new Cliente(4,"samuel","eto","22245678f","555555","otro@gmail.com"));
		}};
		
		producto = new ArrayList<>() {{
			
			add(new Producto("Los mercenarios",Tipo.DVD, Estado.BUENO));
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
		
		if(comprobar.ComprobarCliente(cli, cliente)) {
	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente ya existe");
		}else {
			
			cliente.add(cli);
			return ResponseEntity.status(HttpStatus.CREATED).body(cli);

		}
	}

	@GetMapping("/Cliente/{nombre}") //al hacer el path variable segun el parametro que le pase coje un metodo o otro y siempre pones cliente o lo que sea para que no sepan que metodo uso
	@ResponseBody
	public ResponseEntity<?> leerCliente(@PathVariable("nombre") String nombre){
		
		boolean encontrado=false;
		List<Cliente> nuevoArray = new ArrayList<Cliente>();
		
		for(int i=0; i<cliente.size(); i++) {
			
			if(cliente.get(i).getNombre().equalsIgnoreCase(nombre)) {
				nuevoArray.add(cliente.get(i));
				encontrado=true;
			}
			
		}
		
		if(!encontrado) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen clientes con ese nombre");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(nuevoArray);
		}	
		
	}
	

	
	@PutMapping(path="/updateCliente")
	public ResponseEntity<?> updateCli(@RequestBody Cliente cli, @RequestParam String dni){
		
		boolean encontrado=false;
		
		for(int i=0; i<cliente.size() && encontrado!=true; i++) {
			
			if(cliente.get(i).getDni().equalsIgnoreCase(dni)) {
				
				cliente.get(i).setNombre(cli.getNombre());
				cliente.get(i).setApellido(cli.getApellido());
				cliente.get(i).setGmail(cli.getGmail());
				cliente.get(i).setTelefono(cli.getTelefono());
				encontrado=true;
			}
			
		}
		
		if(!encontrado) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe la persona");
			
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Actualizado correctamente");
		}
		
		
	}
	
	
	@DeleteMapping(path="/borrarCliente")
	public ResponseEntity<?> borrarCliente(@RequestParam String dni){
		
		boolean encontrado=false;
		
		for(int i=0; i<cliente.size() && encontrado!=true; i++) {
			
			if(cliente.get(i).getDni().equalsIgnoreCase(dni)) {
				
				cliente.remove(i);
				encontrado=true;
				
			}
		}
		
		if(!encontrado) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe la persona");

		}else {
			return ResponseEntity.status(HttpStatus.OK).body("El cliente ha sido borrado");

		}
	}
	
	@PostMapping(path = "/crearProducto")
	public ResponseEntity<?> añadirProducto(@RequestBody Producto pro) {
		boolean existe=false;
		
		if(comprobarProducto.ComprobarProducto(pro, producto)) {
	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto ya existe");
		}else {
			
			producto.add(pro);
			return ResponseEntity.status(HttpStatus.CREATED).body(pro);

		}
	}

	@GetMapping(path="/buscarProducto")
	public ResponseEntity<?> leerProducto(@RequestParam String titulo){
		
		boolean encontrado=false;
		List<Producto> nuevoArray = new ArrayList<Producto>();
		
		for(int i=0; i<cliente.size(); i++) {
			
			if(cliente.get(i).getNombre().equalsIgnoreCase(titulo)) {
				nuevoArray.add(producto.get(i));
				encontrado=true;
			}
			
		}
		
		if(!encontrado) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen productos con ese nombre");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(nuevoArray);
		}	
		
	}
	
	@PutMapping(path="/updateProducto")
	public ResponseEntity<?> updatePro(@RequestBody Producto pro, String titulo){
		
		boolean encontrado=false;
		for(int i=0; i<producto.size(); i++) {
			
			if(producto.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				
				producto.get(i).setTitulo(pro.getTitulo());
				producto.get(i).setEstado(pro.getEstado());
				producto.get(i).setTipo(pro.getTipo());
				encontrado=true;
		
			}
		}
		
		if(!encontrado) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen productos con ese nombre");
			
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Producto actualizado");
			
		}
		
	}
	
	@DeleteMapping(path = "/borrarProducto")
	public ResponseEntity<?> borrarProducto(@RequestBody Producto pro, String titulo){
		
		
		boolean encontrado=false;
		for(int i=0; i<producto.size(); i++) {
			
			if(producto.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				
				producto.remove(i);
				encontrado=true;		
			}
		}
		
		if(!encontrado) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen productos con ese nombre");
			
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Producto borrado");
			
		}
		
		
	}
	

}
