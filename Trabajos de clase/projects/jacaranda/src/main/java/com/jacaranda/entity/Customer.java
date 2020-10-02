package com.jacaranda.entity;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * 
 * Customer entity
 * @author estudiante
 *
 */

public class Customer implements Serializable { // se tiene que poner el serializable para que se encapsule  
											   //y desencapsule manteniendo el formato desde cualquier lado
	
	private String name;
	private String surname;
	private LocalDate birthDate;
	private String address;
	private String city;
	private String dni;
	private String country;
	private String mobileNumber;
	private String gender;	
	private int id;
	
	
	public Customer() {
		
	}
	
	public Customer(String name, String surname, LocalDate birthDate, String address, String city, String dni,
			String country, String mobileNumber, String gender) {
		
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.address = address;
		this.city = city;
		this.dni = dni;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
	}
	
	public Customer(String name, String surname, String city, String dni, int id) {
		
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.dni = dni;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
