package com.akhilexpress.api.dao;

import java.util.List;

import com.akhilexpress.api.Student;

public interface StudentDAO {

	List<Student> getAllStudents();

	Student getStudentById(int id) ;
	Student getStudentByName(String name);
	Student saveStudent(Student student);

	Student updateStudent(Student student);
	
	int findStudentListSize();
}
