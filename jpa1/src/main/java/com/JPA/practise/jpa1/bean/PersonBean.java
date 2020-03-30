package com.JPA.practise.jpa1.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonBean {

	@Id
	private int id;
	private String name;
	private String location;
	//private Date birthDate;

	public PersonBean() {
		super();
	}

	public PersonBean(int id, String name, String location/*, Date birthDate*/) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		//this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

//	public Date getBirthDate() {
//		return birthDate;
//	}
//
//	public void setBirthDate(Date birthDate) {
//		this.birthDate = birthDate;
//	}

}
