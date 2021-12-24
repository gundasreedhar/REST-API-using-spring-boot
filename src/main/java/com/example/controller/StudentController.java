package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Address;
import com.example.entity.StudentEntity;
import com.example.entity.Subject;
import com.example.requestpayload.StudentRequestPOJO;
import com.example.responsePOJO.StudentResponsePOJO;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student/")  
public class StudentController {
	
	@Value("${appName}")
	String appName;
	
	
	@GetMapping("/getAppName")
	public String getAppName()
	{
		return appName;
	}
	
	
	@Autowired
	StudentService studentService;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@GetMapping("/getAllStudents")
	public List<StudentEntity> getAllStudentInTable()
	{
//		logger.error("inside error");
//		logger.warn("inside warn");
//		logger.info("inside info");
//		logger.debug("inside info");
//		logger.trace("inside info");
		
		List<StudentEntity> listOfStudents = studentService.getAllStudentInTable();
		List<StudentResponsePOJO> listOfStudentResponsePOJO = new ArrayList<StudentResponsePOJO>();
		for(StudentEntity student : listOfStudents)
		{
			listOfStudentResponsePOJO.add(new StudentResponsePOJO(student));
		}
		return listOfStudents;
	}
	
	@GetMapping("/getByFirstName")
	public List<StudentResponsePOJO> getByFirstName(@RequestParam String fName) 
	{
		//logger.info("Request Param  : " + fName);
		
		
		List<StudentEntity> listOfStudents = studentService.getByFirstName(fName);
		List<StudentResponsePOJO> studentResponsePOJO = new ArrayList<StudentResponsePOJO>();
		for(StudentEntity student : listOfStudents)
		{
			studentResponsePOJO.add(new StudentResponsePOJO(student));
		}
		logger.info("response  : " + studentResponsePOJO);
		
		
		return studentResponsePOJO;
	}
	
	
	@PostMapping("/createTheStudent")
	public StudentResponsePOJO createStudentRecord(@RequestBody StudentRequestPOJO studentRequestPOJO)
	{
		StudentEntity studentEntuty = studentService.createStudentRecord(studentRequestPOJO);
		
		return new StudentResponsePOJO(studentEntuty);
	}
	
	@PutMapping("/enrolleStudentsToSubjects")
	public void enrolleStudentsToSubjects(@RequestParam int subjectID, int studentId)
	{
		studentService.enrolleStudentsToSubjects(subjectID,studentId);
	}
	 
	@PutMapping("/updateStudent")
	public void updateStduent(@RequestParam int id, String fName,String lName)
	{
		studentService.updateStduent(id,fName,lName);
		
	}
	
	
	@DeleteMapping("/deleteStudent")
	public void updateStduent(@RequestParam int id)
	{
		studentService.deleteStduent(id);
		
	}
	
	@GetMapping("/getAdrress")
	public List<Address> getAdrress()
	{
		return studentService.getAdrress();
	}
	
	@GetMapping("/getSubjects")
	public List<Subject> getSubjects()
	{
		return studentService.getSubjects();
	}
	
	@PutMapping("/updtestudentsaddressdetails")
	public int updtestudentsaddressdetails(@RequestParam String firstName,String lastName,String area,String city)
	{
		 return studentService.updtestudentsaddressdetails(firstName,lastName,area,city);
	}
	
	@PostMapping("/enrollStudentsToSubjects")
	public void enrollStudentsToSubjects(@RequestParam int studentId,int subjectId)
	{
		studentService.enrollStudentsToSubjects(studentId,subjectId);
	}
	
	
}
