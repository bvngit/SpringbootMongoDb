package com.bvn.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bvn.demo.model.Student;
import com.bvn.demo.repositories.StudentRepository;

@RestController
public class StudentResource {
	
//	@Autowired
	private StudentRepository studentRepo;
	
	public StudentResource(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@GetMapping(value="/all")
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}
	
	@PostMapping(value="/create")
	public String createStudent(@RequestBody Student student) {
		Student insertedStudent = studentRepo.insert(student);
		
		return "Student created " + insertedStudent.getName();
	}
}
