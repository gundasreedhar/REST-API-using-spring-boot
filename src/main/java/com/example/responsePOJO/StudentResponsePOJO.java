package com.example.responsePOJO;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.StudentEntity;
import com.example.entity.Subject;

public class StudentResponsePOJO {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private long address_id;
	
	private String area;
	
	private String city;
	
	private List<SubjectResponsePOJO> lerningSubjects;
	
	
	
	
	
	
	public StudentResponsePOJO(){}
	
	public StudentResponsePOJO(StudentEntity student)
	{
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.address_id = student.getAddressId().getId();
		this.area = student.getAddressId().getArea();
		this.city = student.getAddressId().getCity();
		
		lerningSubjects = new ArrayList<SubjectResponsePOJO>();
		for(Subject s :student.getSubject())
		{
			SubjectResponsePOJO subjectResponsePOJO = new SubjectResponsePOJO(s);
			lerningSubjects.add(subjectResponsePOJO);
		}
		
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

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
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

	public List<SubjectResponsePOJO> getLerningSubjects() {
		return lerningSubjects;
	}

	public void setLerningSubjects(List<SubjectResponsePOJO> lerningSubjects) {
		this.lerningSubjects = lerningSubjects;
	}

	@Override
	public String toString() {
		return "StudentResponsePOJO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address_id="
				+ address_id + ", area=" + area + ", city=" + city + ", lerningSubjects=" + lerningSubjects + "]";
	}
	
	
	
	
	
	
	
	
}
