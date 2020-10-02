package com.jacaranda.entity;

public class Producto {
	
	private int id;
	private String titulo;
	private Tipo tipo;
	private Estado estado;
	
	
	public Producto() {
		
		
	}
	
	
	public Producto(int id, String titulo, Tipo tipo, Estado estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Producto [id=" + id + ", titulo=" + titulo + ", tipo=" + tipo + ", estado=" + estado + "]";
	}
	
	
	
	
	
	

}
