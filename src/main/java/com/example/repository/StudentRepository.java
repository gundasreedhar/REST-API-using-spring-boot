package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>
{
	List<StudentEntity> findByFirstName(String fname); 
	
	StudentEntity findByFirstNameAndLastName(String fName,String lName);
	
	@Modifying
	@Transactional
	@Query("update StudentEntity set firstName = :fName,lastName = :lName where id = :id")
	void updateRecord(long id, String fName,String lName);
	
	@Modifying
	@Transactional
	@Query("delete from StudentEntity where id = :id")
	void deleteRecord(long id);
	
	
}
