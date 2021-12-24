package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long>{
	
}
