package com.thinknear.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinknear.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	
	public List<?> findByClasses_Code(String code);
	public List<?> findByLastNameOrFirstNameOrClasses_Code(String lastName, String firstName, String code);
}
