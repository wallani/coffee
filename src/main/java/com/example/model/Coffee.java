package com.example.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
/** 
 * 
 * 
 * **/
@Entity
public class Coffee {
	private String name;
	@Id
	private String id;

	@Override
	public String toString() {
		return "Coffe [name=" + name + ", id=" + id + "]";
	}

	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	
	public Coffee(String name, String id) {
		this.id = id;
		this.name = name;
		
	}

	public Coffee(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
