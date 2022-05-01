package com.akhilexpress.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akhilexpress.api.BatchInfo;
import com.akhilexpress.api.Student;
import com.akhilexpress.api.dao.StudentDAO;

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
	public Student getStudents() {
		Student student = new Student(1, "Akhilesh", "India");
		BatchInfo batchInfo = new BatchInfo("Spring+Hibernate", "Abhilash");
	//	student.setBatchInfo(batchInfo);
		return student;
	}

	@GetMapping(value = "/all_student", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Student> getAllStudents() {

		return studentDAO.getAllStudents();
	}

	@GetMapping(value = "/student/{id}" ,params="xyz")
	public Student getStudentById(@PathVariable("id") int id)
	{
		System.out.println("Fetching the student with id : "+id);
		return studentDAO.getStudentById(id);
	}
	
	@GetMapping(value = "/student/{name}",params="abc")
	public Student getStudentByName(@PathVariable("name") String name)
	{
		System.out.println("Fetching the student with name : "+name);
		return studentDAO.getStudentByName(name);
	}
	
	//using Query param
	
	/*@PostMapping(value = "/student")
	public Student saveStudents(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("country") String country) 
	{
	Student student=new Student(id, name, country);
		return studentDAO.saveStudent(student);
	}*/
	
	//using Body
	
	@PostMapping("/student")
	public Student saveStudents(@RequestBody Student student) 
	{
	System.out.println(student);
	 student=studentDAO.saveStudent(student);
	 return student;
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
