package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Subject;

public interface SubjectsRepository extends JpaRepository<Subject, Long>{
	
	public Subject findBySubjectName(String subjectName);
}
