package com.jacaranda.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.entity.Cliente;

@Service
public class ExisteUsuario {
	
	
	public boolean ComprobarCliente(Cliente cli, List<Cliente> cliente) {
		
		boolean encontrado=false;
		
		for(int i=0; i<cliente.size() && encontrado!=true; i++) {
			
			if(cliente.get(i).getDni().equalsIgnoreCase(cli.getDni())) {
				encontrado=true;
			}
		}
		
		return encontrado;
		
	}

}
