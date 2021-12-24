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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@JsonIgnore
	
	@ManyToMany
	@JoinTable(
			name = "enrolled_students",  
			joinColumns = @JoinColumn(name = "subject_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
			)
	private Set<StudentEntity> enrolledStudents ;//= new HashSet<StudentEntity>();
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", enrolledStudents=" + enrolledStudents + "]";
	}

	public Subject() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set<StudentEntity> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(Set<StudentEntity> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	

	

	

	

	
	
	
}
