package com.example.responsePOJO;

import com.example.entity.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SubjectResponsePOJO {
	@JsonIgnore
	private int id;
	
	private String SubjectName;
	
	
	
	
	public SubjectResponsePOJO(Subject subject)
	{
		this.id = (int) subject.getId();
		this.SubjectName = subject.getSubjectName();
	}
	
	public SubjectResponsePOJO() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	
	
}
