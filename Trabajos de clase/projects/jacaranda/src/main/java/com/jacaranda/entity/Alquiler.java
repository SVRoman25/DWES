package com.jacaranda.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alquiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numId;
	
	private int duracionDiasAlquiler;
	private boolean devuelto;
	private Date fechaEntrega; 
	private Date fechaDevolucion;
	
	
	public Alquiler() {
		
		
	}
	
		
	public Alquiler(int numId, Cliente cliente, Producto producto, int duracionDiasAlquiler, boolean devuelto,
			Date fechaEntrega, Date fechaDevolucion) {
		super();
		this.numId = numId;
		this.duracionDiasAlquiler = duracionDiasAlquiler;
		this.devuelto = devuelto;
		this.fechaEntrega = fechaEntrega;
		this.fechaDevolucion = fechaDevolucion;
	}




	public int getNumId() {
		return numId;
	}
	public void setNumId(int numId) {
		this.numId = numId;
	}

	public int getDuracionDiasAlquiler() {
		return duracionDiasAlquiler;
	}
	public void setDuracionDiasAlquiler(int duracionDiasAlquiler) {
		this.duracionDiasAlquiler = duracionDiasAlquiler;
	}
	public boolean isDevuelto() {
		return devuelto;
	}
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	



	@Override
	public String toString() {
		return "Alquiler [numId=" + numId 
				+ ", duracionDiasAlquiler=" + duracionDiasAlquiler + ", devuelto=" + devuelto + ", fechaEntrega="
				+ fechaEntrega + ", fechaDevolucion=" + fechaDevolucion + "]";
	}
	
	
	
	

}
