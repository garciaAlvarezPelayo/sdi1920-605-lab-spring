package com.uniovi.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Teacher {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String dni;
	private String name;
	private String surname;
	private String category;

	public Teacher(String dni, String name, String surname, String category) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.category = category;
	}
	
	public Teacher() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Teacher [dni=" + dni + ", name=" + name + ", surname=" + surname + ", category=" + category + "]";
	}
}
