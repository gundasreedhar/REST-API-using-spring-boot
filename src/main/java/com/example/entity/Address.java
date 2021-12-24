package com.example.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "city")
	private String city;
	
	@JsonIgnore
	@OneToMany(mappedBy = "addressId")
	private Set<StudentEntity> student;
	
	
	@OneToOne
	@JoinColumn(name = "parent_id")
	private Parent parents;		// owning side
	
	
	
	
	
	public Address(String area,String city)
	{
		this.area = area;
		this.city = city;
	}
	
	
	public Set<StudentEntity> getStudent() {
		return student;
	}

	public void setStudent(Set<StudentEntity> student) {
		this.student = student;
	}

	public Address() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Parent getParents() {
		return parents;
	}

	public void setParents(Parent parents) {
		this.parents = parents;
	}

	
	
	
	
	
}
