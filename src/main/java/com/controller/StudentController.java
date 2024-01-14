package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.*;
import com.service.StudentService;
import java.util.*;
@RestController
@CrossOrigin("http://localhost:4200/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//Insert 
	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		return this.studentService.save(student);
	}
	@PostMapping("/saveAll")
	public List<Student> save(@RequestBody List<Student> students) {
		return this.studentService.saveAll(students);
	}
	
	//Update 
	@PutMapping("/update/{id}")
	public Student update(@RequestBody Student student,@PathVariable("id") int id) {
		return this.studentService.update(id, student);
	}
	
	//Delete 
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.studentService.delete(id);
	}
	
	//Select
	@GetMapping("/getById/{id}")
	public Student getById(@PathVariable int id) {
		return this.studentService.getById(id);
	}
	@GetMapping("/getByName/{name}")
	public List<Student> getByName(@PathVariable String name){
		return this.studentService.getByName(name);
	}
	@GetMapping("/getByCity/{city}")
	public List<Student> getByCity(@PathVariable String city){
		return this.studentService.getByName(city);
	}
	@GetMapping("/getAll")
	public List<Student> getAll(){
		return this.studentService.getAll();
	}
	

	
}
