package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.*;
import com.entity.*;
import java.util.*;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	// Insert
	public Student save(Student student) {
		return this.studentDao.save(student);
	}

	public List<Student> saveAll(List<Student> students) {
		return this.studentDao.saveAll(students);
	}

	// Delete

	public void delete(int id) {
		this.studentDao.deleteById(id);
	}

	// Update
	public Student update(int id, Student student) {
		Optional<Student> stud = this.studentDao.findById(id);
		Student s = stud.get();
		s.setName(student.getName());
		s.setCity(student.getCity());
		return this.studentDao.save(s);

	}

	// Select
	public Student getById(int id) {
		return this.studentDao.findById(id).get();
	}

	public List<Student> getByName(String name) {
		Iterable<Student> students = this.studentDao.findByName(name);
		return (List<Student>) students;
	}

	public List<Student> getByCity(String city) {
		return (List<Student>) this.studentDao.findByCity(city);
	}

	public List<Student> getAll() {
		return (List<Student>) this.studentDao.findAll();
	}

}
