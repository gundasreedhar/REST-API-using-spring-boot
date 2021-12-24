package com.example.requestpayload;

import java.util.Set;

import com.example.entity.Subject;

public class StudentRequestPOJO {
	private String fatherName;
	private String motherName;
	
	private String area;
	private String city;
	
	private String fName;
	private String lName;
	
	private Set<Subject> subjectName;
	 
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
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
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Set<Subject> getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(Set<Subject> subjectName) {
		this.subjectName = subjectName;
	}
	
	
	
	
	
	
	
	
	
}
