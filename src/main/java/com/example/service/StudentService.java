package com.example.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.entity.Parent;
import com.example.entity.StudentEntity;
import com.example.entity.Subject;
import com.example.repository.AddressrepositoryDAO;
import com.example.repository.ParentRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectsRepository;
import com.example.requestpayload.StudentRequestPOJO;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressrepositoryDAO addressrepository;
	
	@Autowired
	SubjectsRepository subjectsRepository;
	
	@Autowired
	ParentRepository parentRepository;
	
	public List<StudentEntity> getAllStudentInTable()
	{
		return studentRepository.findAll();
	}
	
	public List<StudentEntity> getByFirstName(String fName)
	{
		return studentRepository.findByFirstName(fName);
	}
	
	public StudentEntity createStudentRecord(StudentRequestPOJO studentRequestPOJO)
	{
		
		//if(parentRepository.find)
		Parent parent = new Parent(studentRequestPOJO.getFatherName(),studentRequestPOJO.getMotherName());
		parentRepository.save(parent);
		
		Address address = new Address(studentRequestPOJO.getArea(),studentRequestPOJO.getCity());
		address.setParents(parent);
		addressrepository.save(address);
			
		StudentEntity studentEntity = new StudentEntity(studentRequestPOJO);
		studentEntity.setAddressId(address);
		
		studentEntity = studentRepository.save(studentEntity);
		
		/*
		for(Subject s  : enrolledSubjects)
		{
		//	s.getEnrolledStudents().add(studentEntity);
			Subject subject = subjectsRepository.findBySubjectName(s.getSubjectName());
			if(subject==null)
			{
				subjectsRepository.save(s);
				
			}
			else 
				subject =null;
		}
		*/
		
		/*
		 * for(Subject s : enrolledSubjects) { studentEntity.getSubject().add(s); }
		 */
		
		Set<Subject> enrolledSubjects = studentRequestPOJO.getSubjectName();
		studentEntity.setSubject(enrolledSubjects); //  we are setting this only becoz to generate the subjects in StudentResponse 
		
		
		// for enrolling the students to the subjects
		// we made subject class as owning side
		// we need to add the same student to the all the mentioned subjects
		// now to enroll the student to the subject we make use of already present subject record in the subject table. 
		// now in this subject object already id and subject_name will be present. now u need to set the student object to it and perform save.
		// here subject table is pre-loaded already. everytime u need to fetch and update the students list.
		for(Subject s : enrolledSubjects)
		{
			if(subjectsRepository.findBySubjectName(s.getSubjectName())!=null)  // this check is, if user enters wrong subject name. 
			{
				Subject subject = subjectsRepository.findBySubjectName(s.getSubjectName());  // get the subject from subject table by using the subject name and keep updating its fields and save
				subject.getEnrolledStudents().add(studentEntity);  // and keep updating the enrolledStudents field of subject with the studentEntity record
				subjectsRepository.save(subject);  // MOST IMP: upon doing this we set the student_id and subject_id into "enrolled_students" table  
			}
			else 
			{
				//if entered wrong subject name while creating the record then throw the exception
				throw new IllegalArgumentException("please enter the correct subject names");
			}
				
		}
		
		
		
		
		return studentEntity;
		
	}
	
	public void enrolleStudentsToSubjects(int subjectId,int studentId)
	{
		
	}
	
	
	
	public void updateStduent(int id, String fName,String lName)
	{
		studentRepository.updateRecord(id ,fName, lName);
	}
	
	
	public void deleteStduent(int id)
	{
		studentRepository.deleteRecord(id);
	}
	
	
	public List<Address> getAdrress()
	{
		return addressrepository.findAll();
	}
	
	public List<Subject> getSubjects()
	{
		return subjectsRepository.findAll();
	}
	
	
	public int updtestudentsaddressdetails(String firstName,String lastName,String area,String city)
	{
		StudentEntity stduents= studentRepository.findByFirstNameAndLastName(firstName,lastName);
		int id = (int) stduents.getAddressId().getId();
		return addressrepository.updateAddress(id,area,city);
	}

	public void enrollStudentsToSubjects(int studentId, int subjectId) {
			
			Subject subject = subjectsRepository.findById((long) subjectId).get();
			StudentEntity student = studentRepository.findById((long)studentId).get();
			subject.getEnrolledStudents().add(student);
			subjectsRepository.save(subject);
	}
	
}
