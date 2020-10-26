package com.jacaranda.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID=0;
	private String titulo;
	private Tipo tipo;
	private Estado estado;
	
	
	public Producto() {
		
		
	}
	
	
	public Producto(String titulo, Tipo tipo, Estado estado) {
		super();
		this.ID = ID++;
		this.titulo = titulo;
		this.tipo = tipo;
		this.estado = estado;

	}
	
	
	public int getID() {
		return ID;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Producto [id=" + ID + ", titulo=" + titulo + ", tipo=" + tipo + ", estado=" + estado + "]";
	}
	
	
	
	
	
	

}
