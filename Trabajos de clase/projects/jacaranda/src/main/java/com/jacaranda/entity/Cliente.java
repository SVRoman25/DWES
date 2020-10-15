package com.jacaranda.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Cliente {
	
	private  static int ID=0;
	
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String gmail;
	
	public Cliente() {
		
	}
	
	public Cliente(String nombre, String apellido, String dni, String telefono, String gmail) {
		super();
		this.ID = ID++;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.gmail = gmail;
	}
	

	public static int getID() {
		return ID;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + ID+ ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", telefono="
				+ telefono + ", gmail=" + gmail + "]";
	}
	
	
	
	
	

}
