package com.akhilexpress.restControllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akhilexpress.api.BatchInfo;
import com.akhilexpress.api.Student;
import com.akhilexpress.api.StudentErrorResponse;
import com.akhilexpress.api.dao.StudentDAO;
import com.akhilexpress.exception.StudentNotFound;

/*
 We can create multiple same endpoint but they has to attach to different http requestt
 */

//@Controller
//@ResponseBody
@RestController
public class MyFirstRestController {

	@Autowired
	private StudentDAO studentDAO;

	@GetMapping(value = "/student", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Student getStudent() {
		Student student = new Student(1, "Akhilesh", "India");
		BatchInfo batchInfo = new BatchInfo("Spring+Hibernate", "Abhilash");
	//	student.setBatchInfo(batchInfo);
		return student;
	}

	@GetMapping(value = "/all_student", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> studentList= studentDAO.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(studentList);
	}

	@GetMapping(value = "/student/{id}" ,params="xyz")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) throws Exception
	{
		if(studentDAO.findStudentListSize()<id)
		{
			//throw new Exception("id not found");
			throw new StudentNotFound("Student with id not found "+id);
				}
		System.out.println("Fetching the student with id : "+id);
		Student student= studentDAO.getStudentById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
	}
	
	/*@GetMapping(value = "/student/{name}",params="abc")
	public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name)
	{
		System.out.println("Fetching the student with name : "+name);
		Student student= studentDAO.getStudentByName(name);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
		
	}*/
	
	//using Query param
	
	/*@PostMapping(value = "/student")
	public Student saveStudents(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("country") String country) 
	{
	Student student=new Student(id, name, country);
		return studentDAO.saveStudent(student);
	}*/
	
	//using Body
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudents(@RequestBody Student student) 
	{
	System.out.println(student);
	 student=studentDAO.saveStudent(student);
	 return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}
	
	@PutMapping("/student")
	public Student updateStudents(@RequestBody Student student) 
	{
	System.out.println(student);
	 student=studentDAO.updateStudent(student);
	 return student;
	}
	
	//Whenever the exception StudentNotFound i will be returning StudentErrorresponse.
	@ExceptionHandler
	ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFound snf)
	{
		StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
		
		studentErrorResponse.setDate(new Date());
		studentErrorResponse.setErrorClass(snf.getClass().toString());
		studentErrorResponse.setErrorMessage(snf.getMessage());
		
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentErrorResponse);
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	ResponseEntity<StudentErrorResponse> handleXYZException(Exception snf)
	{
		StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
		
		studentErrorResponse.setDate(new Date());
		studentErrorResponse.setErrorClass(snf.getClass().toString());
		studentErrorResponse.setErrorMessage(snf.getMessage());
		
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentErrorResponse);
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse,HttpStatus.NOT_FOUND);
		
	}
	

	@GetMapping("/hello")
	public String getMethod() {
		return "Hello Everyone";
	}

	@PostMapping("/hello")
	public String postMethod() {
		return "Hello Everyone";
	}

	@PutMapping("/hello")
	public String putMethod() {
		return "Hello Everyone";
	}

	@DeleteMapping("/hello")
	public String deleteMethod() {
		return "Hello Everyone";
	}

}
