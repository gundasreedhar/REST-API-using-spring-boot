package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.requestpayload.StudentRequestPOJO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class StudentEntity
{
	@Id  // for primary key to represent
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment value since we mentioned auto_increment in table in dB
	@Column(name = "id")  
	private Long id;   // This must and shud be Long only if not the @GeneratedValue will not work to auto_increment the id
	
	@Column(name = "fname")
	private String firstName;
	
	@Column(name = "lname")
	private String lastName;
	
	
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address addressId;
	
	
	//@JsonIgnore
	
	@ManyToMany(mappedBy = "enrolledStudents")
	private Set<Subject> subject ;//= new HashSet<>();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public StudentEntity() {}
	
	public StudentEntity(StudentRequestPOJO studentRequestPOJO)
	{
		this.firstName = studentRequestPOJO.getfName();
		this.lastName = studentRequestPOJO.getlName();
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public Set<Subject> getSubject() {
		return subject;
	}

	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addressId="
				+ addressId + ", subject=" + subject + "]";
	}
	
	
	

	

	
	
	

	
	
	
	
	
}
