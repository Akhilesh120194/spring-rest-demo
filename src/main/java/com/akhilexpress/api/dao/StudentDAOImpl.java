package com.akhilexpress.api.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.akhilexpress.api.Student;

@Component
public class StudentDAOImpl implements StudentDAO{
	
	ArrayList<Student> studentList=new ArrayList<Student>();
	
	@PostConstruct
	public void setupStudentData()
	{
		
		System.out.println("Setup method called ");
		
		Student s1=new Student(1, "Rahul", "India");
		Student s2=new Student(2, "lavanya", "India");
		Student s3=new Student(3, "Rama", "India");
		Student s4=new Student(4, "Akhil", "India");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentList;
	}

	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		
		return studentList.get(--id);
	}

	public Student getStudentByName(String name) {
		// TODO Auto-generated method stub
		Student student=null;
		for(Student temp:studentList)
		{
			if(temp.getName().equals(name))
			{
				return temp;
			}
		}
		return null;
	}

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		studentList.add(student);
		return student;
	}

	public Student updateStudent(Student student) {
		
				return null;
	}

	public int findStudentListSize() {
		// TODO Auto-generated method stub
		return studentList.size();
	}

}
