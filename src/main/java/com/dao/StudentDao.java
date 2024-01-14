package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.*;
public interface StudentDao extends JpaRepository<Student,Integer> {

	@Query(value="select * from student where name=:name",nativeQuery=true)
	public List<Student> findByName(@Param("name") String name);
	
	@Query(value="select * from student where city=:city",nativeQuery=true)
	public List<Student> findByCity(@Param("city") String city);
	
}
