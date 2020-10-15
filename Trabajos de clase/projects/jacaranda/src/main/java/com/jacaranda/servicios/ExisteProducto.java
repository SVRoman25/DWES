package com.jacaranda.servicios;

import java.util.List;

import com.jacaranda.entity.Producto;

public class ExisteProducto {

	public boolean ComprobarProducto(Producto pro, List<Producto> producto) {
		
		boolean encontrado=false;
		
		for(int i=0; i<producto.size() && encontrado!=true; i++) {
			
			if(producto.get(i).getTitulo().equalsIgnoreCase(pro.getTitulo())) {
				encontrado=true;
			}
		}
		
		return encontrado;
		
	}

}
