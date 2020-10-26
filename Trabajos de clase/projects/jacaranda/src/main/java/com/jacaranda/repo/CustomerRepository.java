package com.jacaranda.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Cliente;

@Repository(value = "customerRepository")
public interface CustomerRepository extends CrudRepository<Cliente, Integer>{
	
	public Cliente findClienteByDni(String dni);
	
	public Cliente saved(Cliente cliente);
	
	public List<Cliente>findByNombre(String nombre);
	
	
}
